// ORM class for table 'app_interesting_m'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Tue Sep 08 13:29:47 CST 2015
// For connector: org.apache.sqoop.manager.GenericJdbcManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class app_interesting_m extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private String pkgname;
  public String get_pkgname() {
    return pkgname;
  }
  public void set_pkgname(String pkgname) {
    this.pkgname = pkgname;
  }
  public app_interesting_m with_pkgname(String pkgname) {
    this.pkgname = pkgname;
    return this;
  }
  private String vercode;
  public String get_vercode() {
    return vercode;
  }
  public void set_vercode(String vercode) {
    this.vercode = vercode;
  }
  public app_interesting_m with_vercode(String vercode) {
    this.vercode = vercode;
    return this;
  }
  private String md5;
  public String get_md5() {
    return md5;
  }
  public void set_md5(String md5) {
    this.md5 = md5;
  }
  public app_interesting_m with_md5(String md5) {
    this.md5 = md5;
    return this;
  }
  private Integer type;
  public Integer get_type() {
    return type;
  }
  public void set_type(Integer type) {
    this.type = type;
  }
  public app_interesting_m with_type(Integer type) {
    this.type = type;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof app_interesting_m)) {
      return false;
    }
    app_interesting_m that = (app_interesting_m) o;
    boolean equal = true;
    equal = equal && (this.pkgname == null ? that.pkgname == null : this.pkgname.equals(that.pkgname));
    equal = equal && (this.vercode == null ? that.vercode == null : this.vercode.equals(that.vercode));
    equal = equal && (this.md5 == null ? that.md5 == null : this.md5.equals(that.md5));
    equal = equal && (this.type == null ? that.type == null : this.type.equals(that.type));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.pkgname = JdbcWritableBridge.readString(1, __dbResults);
    this.vercode = JdbcWritableBridge.readString(2, __dbResults);
    this.md5 = JdbcWritableBridge.readString(3, __dbResults);
    this.type = JdbcWritableBridge.readInteger(4, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(pkgname, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(vercode, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(md5, 3 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeInteger(type, 4 + __off, 4, __dbStmt);
    return 4;
  }
  public void readFields(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.pkgname = null;
    } else {
    this.pkgname = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.vercode = null;
    } else {
    this.vercode = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.md5 = null;
    } else {
    this.md5 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.type = null;
    } else {
    this.type = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.pkgname) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, pkgname);
    }
    if (null == this.vercode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, vercode);
    }
    if (null == this.md5) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, md5);
    }
    if (null == this.type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.type);
    }
  }
  private final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(pkgname==null?"null":pkgname, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(vercode==null?"null":vercode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(md5==null?"null":md5, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(type==null?"null":"" + type, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  private final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str;
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.pkgname = null; } else {
      this.pkgname = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.vercode = null; } else {
      this.vercode = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.md5 = null; } else {
      this.md5 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.type = null; } else {
      this.type = Integer.valueOf(__cur_str);
    }

  }

  public Object clone() throws CloneNotSupportedException {
    app_interesting_m o = (app_interesting_m) super.clone();
    return o;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("pkgname", this.pkgname);
    __sqoop$field_map.put("vercode", this.vercode);
    __sqoop$field_map.put("md5", this.md5);
    __sqoop$field_map.put("type", this.type);
    return __sqoop$field_map;
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("pkgname".equals(__fieldName)) {
      this.pkgname = (String) __fieldVal;
    }
    else    if ("vercode".equals(__fieldName)) {
      this.vercode = (String) __fieldVal;
    }
    else    if ("md5".equals(__fieldName)) {
      this.md5 = (String) __fieldVal;
    }
    else    if ("type".equals(__fieldName)) {
      this.type = (Integer) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
}
