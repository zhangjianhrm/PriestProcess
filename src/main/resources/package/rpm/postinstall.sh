#!/usr/bin/env bash
cd /var/lib/priest
tar -zxvf /var/lib/priest/process-LEAP-1.0.1-r0001-5.2.1-ldh1.2.0+3.el6.x86_64/process-LEAP-1.0.1-r0001-5.2.1-ldh1.2.0+3.el6.x86_64.tar.gz
tar -zxvf /var/lib/priest/process-LEAP-1.0.1-r0001-5.2.1-ldh1.2.0+3.el6.x86_64/jdk1.7.0_67-cloudera.tar.gz
mv /var/lib/priest/process-LEAP-1.0.1-r0001-5.2.1-ldh1.2.0+3.el6.x86_64/jetty/* /var/lib/priest/
mkdir /var/lib/priest/graphviz
cd /var/lib/priest/graphviz
tar -zxvf /var/lib/priest/process-LEAP-1.0.1-r0001-5.2.1-ldh1.2.0+3.el6.x86_64/graphviz.tar.gz
rm -rf /var/lib/priest/process-LEAP-1.0.1-r0001-5.2.1-ldh1.2.0+3.el6.x86_64
mkdir /var/lib/priest/webapps/process
cd /var/lib/priest/webapps/process
unzip /var/lib/priest/webapps/process-LEAP-1.0.1-r0001-5.2.1-ldh1.2.0+3.el6.x86_64.war
rm -rf /var/lib/priest/webapps/process-LEAP-1.0.1-r0001-5.2.1-ldh1.2.0+3.el6.x86_64.war
chmod -R 777 /var/lib/priest/bin
#if ! rpm -qa | grep -q graphviz ; then
	#sudo rm -rf /var/lib/rpm/.rpm.lock
    #sudo rpm -ivh /var/lib/priest/graphviz/graphviz-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-gd-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-devel-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-guile-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-tcl-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-lua-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-ruby-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-perl-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-python-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-java-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-php-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-doc-2.26.0-10.el6.x86_64.rpm
	#sudo rpm -ivh /var/lib/priest/graphviz/graphviz-graphs-2.26.0-10.el6.x86_64.rpm
	#sudo yum install -y 'graphviz*'
#fi

