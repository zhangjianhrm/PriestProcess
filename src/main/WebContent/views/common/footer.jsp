<%@page contentType = "text/html;charset=UTF-8" %>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%
	ResourceBundle bundleFoot = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>
<div class="footer">
	<p><%=bundleFoot.getString("footer")%></p>
</div>

<script type="text/javascript" id="footerjs">
	jQuery(document).ready(function() {
		AFMS.Header.init();
		AFMS.Sider.init();
        
        var historyPages = ['../'
            ,'process_def.jsp'
            ,'process_run_draw.jsp'
            ,'process_run_list.jsp'
            ,'run_history.jsp'
            ,'run_time_history.jsp'
            ,'task.jsp',] ;
        var pathname = location.pathname ;
        var idx = pathname.lastIndexOf('/') + 1 ;
        if ( idx < pathname.length ){
            pathname = pathname.substr( idx ) ;
        }
        if ( $.inArray( pathname , historyPages ) > -1 ) {
            var hjs = document.createElement('script');
            hjs.type  = 'text/javascript';
            hjs.async = true;
            hjs.src   = '../resources/script/history.js' ;

            var s  = document.getElementById('footerjs'); 
            var sp = s.parentNode ;
            sp.lastChild  == s ? sp.appendChild( hjs ) : sp.insertBefore(hjs, s.nextSibling);
        }
	});
</script>