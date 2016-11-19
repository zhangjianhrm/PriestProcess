package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.service.HdfsService;
import com.lenovo.lps.farseer.priest2.platform.service.HiveMetaDao;

public class HiveMetaDaoImpl implements HiveMetaDao {
	private static final Logger logger = Logger.getLogger(HiveMetaDaoImpl.class);
	
	@Resource
	private HdfsService hdfsService;
	
	@Resource
	private ApplicationDao applicationDao;
	
	private static interface MetaStoreAction{
		Object run(HiveMetaStoreClient client) throws SQLException ;
	}
	
	private static class MetaStoreHelper{
		static Object doit(MetaStoreAction action, HiveConf hiveconf) throws SQLException{
			HiveMetaStoreClient client = null ;
			try {
				HadoopUgiServiceImpl.priestLogin();
				client = new HiveMetaStoreClient(hiveconf) ;
				return action.run(client); 				
			} catch (Exception e) {
				throw new SQLException(e);
			} finally{
				if (client != null ) client.close();
			}
		}
	}
	
	/**
	 * 获取hive配置
	 * 
	 * @return
	 * @throws IOException
	 */
	private HiveConf getHiveConf() throws IOException {
		HadoopUgiServiceImpl.priestLogin();
		String metaStoreUri = ConfigUtil.getContextProperty("hive.metastore.uris");
		Assert.isTrue(CommUtils.isNotNull(metaStoreUri), 
				"process config doesn't config hive.metastore.uris!");
		HiveConf hiveconf = new HiveConf();
		hiveconf.setVar(HiveConf.ConfVars.METASTOREURIS,metaStoreUri);
		if ("kerberos".equals(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase())) {
			String kerberosPrincipal = ConfigUtil.getContextProperty("hive.metastore.kerberos.principal");
			Assert.isTrue(CommUtils.isNotNull(kerberosPrincipal), 
					"process config doesn't config hive.metastore.kerberos.principal!");
			hiveconf.setBoolVar(HiveConf.ConfVars.METASTORE_USE_THRIFT_SASL, true);
			hiveconf.setVar(HiveConf.ConfVars.METASTORE_KERBEROS_PRINCIPAL, kerberosPrincipal);
		} else {
			hiveconf.setBoolVar(HiveConf.ConfVars.METASTORE_USE_THRIFT_SASL, false);
		}
		return hiveconf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> descTable(final String schema, final String tableName) throws SQLException, IOException{
		HiveConf hiveconf = getHiveConf();
		Object retlist = MetaStoreHelper.doit(new MetaStoreAction() {
			@Override
			public List<Map<String, Object>> run(HiveMetaStoreClient client) throws SQLException {
				try {
					// 获取hive表meta对象
					List<FieldSchema> fields = client.getFields(schema, tableName);
					List<Map<String,Object>> retlist = new ArrayList<Map<String,Object>>();
					for( FieldSchema field : fields) {
						Map<String,Object> mf = new HashMap<String,Object>();
						mf.put("COLUMN_NAME", field.getName()) ;
						mf.put("COLUMN_TYPE", field.getType()) ;
						retlist.add(mf);	
					}
					return retlist ;
				} catch (Exception e) {
					throw new SQLException(e);
				}
			}
		}, hiveconf);		
		return (List<Map<String, Object>>) retlist ;
	}
	@Override
	public String getFieldsTerminatedBy(final String schema,final String tableName) throws SQLException, IOException {
		HiveConf hiveconf = getHiveConf();
		Object retVal = MetaStoreHelper.doit(new MetaStoreAction() {
			@Override
			public String run(HiveMetaStoreClient client) throws SQLException {
				Map<String, String> m = null;
				try {
					// 获取hive表meta对象
					Table tab = client.getTable(schema, tableName);
					m = tab.getSd().getSerdeInfo().getParameters() ;
					return m.get("field.delim");
				} catch (Exception e) {
					logger.error(String.format("error at getFieldsTerminatedBy by table [%s] schema[%s] params[%s]", tableName,  schema, m));
					throw new SQLException(e);
				}
			}
		}, hiveconf);	
		
		return (String) retVal ;
	}

	@Override
	public String getStorageLocation(final String schema, final String tableName) throws SQLException, IOException {
		HiveConf hiveconf = getHiveConf();
		Object retVal = MetaStoreHelper.doit(new MetaStoreAction() {
			@Override
			public String run(HiveMetaStoreClient client) throws SQLException {
				try {
					// 获取hive表meta对象
					Table tab = client.getTable(schema, tableName);
					return tab.getSd().getLocation();
				} catch (Exception e) {
					throw new SQLException(e);
				}
			}
		}, hiveconf);		
		return (String) retVal ;
	}
}
