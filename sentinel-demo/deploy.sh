#!/bin/bash

project=ll-design-srv
projectPath=/Users/pan/Desktop/workspace/ll-server-design
env=test
version=1.2
ip=192.168.10.124
pass=123456
port=8910
test=false
#account=$9
#accountpass=${10}
repo=192.168.10.124:8889

echo "=============开始本地构建==============="

cd $projectPath || exit 0

if $test;then
  mvn clean install
else
  mvn clean install -Dmaven.test.skip=true
fi

echo "=======本地构建完成，开始上传镜像=========="
echo "=======docker build 有上下文的概念，ADD和COPY命令来说，本地文件必须是在上下文目录中的文件=========="
# 本地没有此镜像，注释
docker rmi -f $repo/$env/$project:$version
docker build -f $projectPath/docker/$env.Dockerfile -t $repo/$env/$project:$version .
#docker tag $env-$project:$version $repo/public/$env-$project:$version

docker login -u admin -p 123456  $repo
#docker rmi -f $repo/$env/$project:$version
docker push $repo/$env/$project:$version

echo "=============镜像上传完成==============="
echo "开启ssh远程部署程序,需要一段时间......"

sshpass -p $pass ssh root@$ip > /dev/null 2>&1 << eeooff
docker stop $env-$project
docker rm -f $env-$project
docker rmi -f $repo/$env/$project:$version
docker pull $repo/$env/$project:$version
docker run --name $env-$project -d -p $port:8080 $repo/$env/$project:$version
exit
eeooff

echo "=============部署并运行完成==============="











