/**
 * Created by Jinhua on 2017/4/24.
 */

$(document).ready(function() {
    let canvas = document.getElementById('canvas');
    let stage = new JTopo.Stage(canvas);
    let scene = new JTopo.Scene(stage);
    scene.background = '/img/bg.png';
    let icons = {1:'green',2: 'blue',3: 'red1',4: 'red2'};

    function addNode(text, color){
        let node = new JTopo.Node();
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

    function bindNode(nodeA, nodeZ){
        let link = new JTopo.CurveLink(nodeA, nodeZ);
        link.strokeColor = '204,204,204';
        link.lineWidth = 1;
        scene.add(link);
        return link;
    }

    //获取当前网址，如： http://localhost:8088/test/test.jsp
    let curPath = window.document.location.href;
    //获取主机地址之后的目录，如： test/test.jsp
    let pathName = window.document.location.pathname;
    let pos = curPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8088
    let localhostPath = curPath.substring(0, pos);
    //同步方法不推荐使用
    let nodeLinks = $.ajax({url:localhostPath + "/api/topo",async:false}).responseText;

    nodeLinks = JSON.parse(nodeLinks)
    let nodeNames = nodeLinks['node'];
    let linkNames = nodeLinks['link'];
    let nodeMap = {};
    for(let i=0; i < nodeNames.length; i++){
        let node = addNode(nodeNames[i]['token'],icons[nodeNames[i]['times']]);
        console.log(node);
        node.layout = {type: 'circle', radius: 60};
        let nodeName = nodeNames[i];
        nodeMap[nodeName['token']] = node;
    }
    for(let j=0; j < linkNames.length; j++){
        let parentNode = nodeMap[linkNames[j].source]
        let childNode = nodeMap[linkNames[j].target]
        bindNode(parentNode,childNode)
    }

    // for(let i=0; i < icons.length; i++){
    //     let node = addNode('second_' + i, icons[i]);
    //     addLink(rootNode, node);
    //     if(i == 0 || i == icons.length - 1){
    //         for(let j=0; j < 4; j++){
    //             let thirdNode = addNode(icons[j], 'green');
    //             addLink(node, thirdNode);
    //         }
    //     }
    // }

    // 树形布局
    scene.doLayout(JTopo.layout.TreeLayout('down', 30, 107));
});
