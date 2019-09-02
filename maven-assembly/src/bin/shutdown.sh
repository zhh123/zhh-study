#! /bin/bash

#======================================================================
# 项目停服shell脚本
# 通过项目名称查找到PID
# 然后kill -9 pid
#
# author: zhh
# date: 2019-06-04
#======================================================================

# 项目名称
APPLICATION="spring-boot-assembly"

# 项目启动jar包名称
APPLICATION_JAR="spring-boot-assembly.jar"

PID=$(ps -ef | grep "${APPLICATION_JAR}" | grep -v grep | awk '{ print $2 }')
if [[ -z "$PID" ]]
then
    echo ${APPLICATION} is already stopped
else
    #echo kill  ${PID}
    #kill -9 ${PID}
    echo ${APPLICATION} stopped successfully
fi