##  spring restful api
```
@RestController
@RequestMapping("/api/Advance")
public class AdvanceApi {

    private final StorageComponent storage;
    private int counter = 0;
    @Autowired
    public AdvanceApi(StorageComponent storage) {
        this.storage = storage;
    }

    @RequestMapping(value = "/hr", method = RequestMethod.GET)
    public ResponseEntity< List<HeuristicResult>> getHeuristicResult() {
        HeuristicResult hr = storage.xzYarnStore().findHeurResById(1);
        List<HeuristicResult> list = new ArrayList<>();
        list.add(hr);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //输入:http://127.0.0.1:9411/api/xz/app_id/121542345?name=xjh,jhx&pass=xjh
    //输出:路径中的id: 121542345
    // request中的数据{name=[Ljava.lang.String;@625c7d72,pass=[Ljava.lang.String;@7955576c}[xjh,jhx]
    @RequestMapping(value = "/app_id/{app_id}", method = RequestMethod.GET)
    public String  getApp(@PathVariable String app_id, WebRequest request) {
        Map<String, String[]> raw = request.getParameterMap();
        String[] name =  request.getParameterValues("name");
        return "路径中的id: "+app_id+"\n request中的数据"+raw+Arrays.toString(name);
    }
    @RequestMapping(value = "/span ", method = RequestMethod.GET)
    public String getSpanName(@RequestParam(value = "span_id", required = false) String span_id) {
        return "get请求中的数据span_id: "+ span_id;
    }
    
    @RequestMapping(value = "/ex", method = RequestMethod.GET)
    public ResponseEntity<String> notFound() {
        return  new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }

    //用于测试缓存,新建标签页输入同样地址时,不会调用getName方法,但刷新页面会调用
    @RequestMapping(value = "/testCache", method = RequestMethod.GET)
    public ResponseEntity<String> testCache() {
        return cacheResponse(getName());
    }
    private String getName(){
        System.out.println("刘禹锡被获取 "+(++counter));
        return "刘禹锡";
    }

    //缓存这个ResponseEntity300秒
    private <T> ResponseEntity<T> cacheResponse(T value){
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        builder.cacheControl(CacheControl.maxAge(300, TimeUnit.SECONDS).mustRevalidate());
        return builder.body(value);
    }


    //需要在beanFactory中取bean才会注入配置文件属性
    @Value("${zipkin.storage.cassandra.contact-points}")
    String somethingToPrint;
}
```
   
