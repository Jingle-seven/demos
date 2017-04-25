/**
 * Created by Jinhua on 2017/4/24.
 */

$(document).ready(function() {
    var canvas = document.getElementById('canvas');
    var stage = new JTopo.Stage(canvas);
    var scene = new JTopo.Scene(stage);
    scene.background = '/img/bg.png';

    var rootNode = addNode(/*[[${session.msg}]]*/"根", 'gray');
    var icons = ['green', 'blue', 'red1', 'red2'];

    function addNode(text, color){
        var node = new JTopo.Node();
        node.setImage('./img/topo/'+ color +'.png', true);
        node.fontColor = '0,0,0';
        scene.add(node);

        node.mouseover(function(){
            this.text = text;
        });
        node.mouseout(function(){
            this.text = null;
        });
        return node;
    }

    function addLink(nodeA, nodeZ){
        var link = new JTopo.FlexionalLink(nodeA, nodeZ);
        link.strokeColor = '204,204,204';
        link.lineWidth = 1;
        scene.add(link);
        return link;
    }

    //获取当前网址，如： http://localhost:8088/test/test.jsp
    var curPath = window.document.location.href;
    //获取主机地址之后的目录，如： test/test.jsp
    var pathName = window.document.location.pathname;
    var pos = curPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8088
    var localhostPath = curPath.substring(0, pos);
    //同步方法不推荐使用
    var leafNames = eval($.ajax({url:localhostPath + "/api/topo",async:false}).responseText);

    for(var i=0; i < icons.length; i++){
        var node = addNode('second_' + i, icons[i]);
        addLink(rootNode, node);
        if(i == 0 || i == icons.length - 1){
            for(var j=0; j < 4; j++){
                var thirdNode = addNode(leafNames[j], 'green');
                addLink(node, thirdNode);
            }
        }
    }

    // 树形布局
    scene.doLayout(JTopo.layout.TreeLayout('down', 30, 107));
});
