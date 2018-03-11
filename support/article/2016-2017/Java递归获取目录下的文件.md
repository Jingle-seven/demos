##  Java递归获取目录下的文件  
```
//递归获取某一目录下所有文件(去除目录)
private List<File> getFilesInDir(List<File> files, int idx){
   //如果下标小于0,退出递归
   if(idx < 0)
      return files;
   //如果是文件,下标减一进行递归
   if(files.get(idx).isFile()){
      //对文件名进行过滤
      if(!files.get(idx).getName().endsWith(".jhist")){
         files.remove(idx);
         return getFilesInDir(files,idx-2);
      }
      return getFilesInDir(files,idx-1);
   }else {
      //否则将此目录下的文件加到List头部,下标加上文件数量进行递归
      File[] fileArr = files.remove(idx).listFiles();
      files.addAll(0,Arrays.asList(fileArr));
      return getFilesInDir(files,idx + fileArr.length -1);
   }
}

```
   
