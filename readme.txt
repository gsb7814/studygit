redhat

查看内存：cat /proc/meminfo | grep MemTotal


java version "1.6.0_22"
OpenJDK Runtime Environment (IcedTea6 1.10.4) (rhel-1.41.1.10.4.el6-x86_64)
OpenJDK 64-Bit Server VM (build 20.0-b11, mixed mode)

Package vsftpd-2.2.2-6.el6_0.1.x86_64 already installed and latest version

Redhat Linux Server release 6.2


[root@localhost bob]# vim /etc/vsftpd/vsftpd.conf
[root@localhost bob]# useradd -d /var/ftp/test -g ftp -s /sbin/nologin ftptest
[root@localhost bob]# passwd ftptest

学习git
$ git config --global user.name "gsb7814"

$ git config --global user.email "xxx@139.com"

 ssh-keygen -t rsa  -P g*. -C "xxx@139.com"

git init

git add Centos.txt
git commit -m "add centos files"
git status
git log
git log --pretty=oneline
git reflog

git reset --hard HEAD^
git reset --hard HEAD~3
git reset --hard commitidxxx

git checkout -- Centos.txt
git reset HEAD Centos.txt
git rm filename

git diff
git diff HEAD -- Centos.txt


把一个已有的本地仓库与远程库（origin）关联
$ cd /e/studygit/
$ git remote add origin git@github.com:gsb7814/studygit.git

(首次)把本地库（master）的所有内容推送到远程库上：
$ git push -u origin master
		Counting objects: 23, done.
		Delta compression using up to 4 threads.
		Compressing objects: 100% (15/15), done.
		Writing objects: 100% (23/23), 2.72 KiB | 0 bytes/s, done.
		Total 23 (delta 6), reused 0 (delta 0)
		To git@github.com:gsb7814/studygit.git
		 * [new branch]      master -> master
		Branch master set up to track remote branch master from origin.

把本地master分支的最新修改推送至GitHub
$ git push origin master

2015年11月9日修改
---------------------------------------------------------------------------------
https://github.com/gsb7814/studygit
https://github.com/gsb7814/studygit.git

 We recommend every repository include a README, LICENSE, and .gitignore.

 …or create a new repository on the command line

echo # studygit >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/gsb7814/studygit.git
git push -u origin master

…or push an existing repository from the command line

git remote add origin https://github.com/gsb7814/studygit.git
git push -u origin master

…or import code from another repository

You can initialize this repository with code from a Subversion, Mercurial, or TFS project.