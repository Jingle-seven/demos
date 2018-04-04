## git 部分命令指南
git clone git@github.com:michaelliao/gitskills.git  
git add  
git commit -m "xxx"  
git checkout -- readme.txt 撤销工作区修改  
git reset --hard HEAD^	版本回退，soft只回退head，mixed是默认，回退head和stage，hard连工作区也回退  
git status  
git diff
git log 提交历史  
git reflog 命令历史  
git merge <name>  
git tag xxx 默认标签是打在最新提交的commit上的,也可git tag v0.9 6224937，git tag 查看标签  
git tag -d v0.1 删除标签  
git push origin <tagname>	推送标签  