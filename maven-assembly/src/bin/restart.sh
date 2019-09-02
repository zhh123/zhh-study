#! /bin/bash

#======================================================================
# 项目重启shell脚本
# 先调用shutdown.sh停服
# 然后调用startup.sh启动服务
#
# author: zhh
# date: 2019-06-04
#======================================================================

# 项目名称
APPLICATION="spring-boot-assembly"

# 项目启动jar包名称
APPLICATION_JAR="spring-boot-assembly.jar"

# 停服
echo stop ${APPLICATION} Application...
sh shutdown.sh

# 启动服务
echo start ${APPLICATION} Application...
sh startup.sh