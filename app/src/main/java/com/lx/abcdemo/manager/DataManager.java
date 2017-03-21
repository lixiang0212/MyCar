package com.lx.abcdemo.manager;

import com.lx.abcdemo.R;
import com.lx.abcdemo.info.Car;
import com.lx.abcdemo.info.CarB;
import com.lx.abcdemo.info.PinyinComparator;
import com.lx.abcdemo.info.PinyinComparatorB;
import com.lx.abcdemo.info.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lixiang on 2017/3/7.
 */

public class DataManager {
    private static DataManager dataManager;

    private DataManager() {
        dataManager = this;
    }
    public static DataManager getInstance(){
        if(dataManager==null){
            dataManager = new DataManager();
        }
        return dataManager;
    }

    public    List<Car> initData(){
        List<Car> cars = new ArrayList<>();
        for (int i=0;i<26;i++) {
            cars.add(new Car(Type.TYPE_TEMP, (char) (i + 65) + ""));
        }
        //a
        cars.add(new Car(Type.TYPE_DATA, R.drawable.aodi,"奥迪"));cars.add(new Car(Type.TYPE_DATA, R.drawable.asidunmading,"阿斯顿马丁"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.babosi,"巴博斯")); cars.add(new Car(Type.TYPE_DATA, R.drawable.baojun,"宝骏"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.baoma,"宝马"));cars.add(new Car(Type.TYPE_DATA, R.drawable.baoshijie,"保时捷"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.baowo,"宝沃"));cars.add(new Car(Type.TYPE_DATA, R.drawable.dazhong,"大众"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.gmc,"GMC"));cars.add(new Car(Type.TYPE_DATA, R.drawable.jeep,"Jeep"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.mg,"MG"));cars.add(new Car(Type.TYPE_DATA, R.drawable.mini,"MINI"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.smart,"smart"));cars.add(new Car(Type.TYPE_DATA, R.drawable.beijinqiche,"北京汽车"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.beiqihuansu,"北汽幻速"));cars.add(new Car(Type.TYPE_DATA, R.drawable.beiqishengbao,"北汽绅宝"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.beiqiweiwang,"北汽威望"));cars.add(new Car(Type.TYPE_DATA, R.drawable.beiqizhizao,"北汽制造"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.benchi,"奔驰"));cars.add(new Car(Type.TYPE_DATA, R.drawable.benten,"奔腾"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.bentian,"本田"));cars.add(new Car(Type.TYPE_DATA, R.drawable.byd,"比亚迪"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.biaozhi,"标志"));cars.add(new Car(Type.TYPE_DATA, R.drawable.bieke,"别克"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.binli,"宾利"));cars.add(new Car(Type.TYPE_DATA, R.drawable.bujiadi,"布加迪"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.changheqiche,"昌河汽车"));cars.add(new Car(Type.TYPE_DATA, R.drawable.daoqi,"道奇"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.dihao,"帝豪"));cars.add(new Car(Type.TYPE_DATA, R.drawable.dongfeng,"东风"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.dongfengfengdu,"东风风度"));cars.add(new Car(Type.TYPE_DATA, R.drawable.dongfengfengxin,"东风风行"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.dongfengfengshen,"东风风神"));cars.add(new Car(Type.TYPE_DATA, R.drawable.dongfengxiaokang,"东风小康"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.dongnan,"东南"));cars.add(new Car(Type.TYPE_DATA, R.drawable.falali,"法拉利"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.feiyate,"菲亚特"));cars.add(new Car(Type.TYPE_DATA, R.drawable.fengtian,"丰田"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.fudi,"福迪"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.futian,"福田"));cars.add(new Car(Type.TYPE_DATA, R.drawable.guanzhi,"观致"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.guangqichuanqi,"广汽传祺"));cars.add(new Car(Type.TYPE_DATA, R.drawable.guangqijiao,"广汽吉奥"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.hafei,"哈飞"));cars.add(new Car(Type.TYPE_DATA, R.drawable.fute,"福特"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.hafo,"哈佛"));cars.add(new Car(Type.TYPE_DATA, R.drawable.haima,"海马"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.hantenqiche,"汉腾汽车"));cars.add(new Car(Type.TYPE_DATA, R.drawable.hanma,"悍马"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.huatai,"华泰"));cars.add(new Car(Type.TYPE_DATA, R.drawable.huataixinnengyuan,"华泰新能源"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.huanghai,"黄海"));cars.add(new Car(Type.TYPE_DATA, R.drawable.jili,"吉利"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.jiliquanqiuyin,"吉利全球鹰"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.jianghuai,"江淮"));cars.add(new Car(Type.TYPE_DATA, R.drawable.jianglin,"江铃"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.jiebao,"捷豹"));cars.add(new Car(Type.TYPE_DATA, R.drawable.jinlong,"金龙"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.jinlu,"金旅"));cars.add(new Car(Type.TYPE_DATA, R.drawable.kaersen,"卡尔森"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.kalaisile,"卡莱斯勒"));cars.add(new Car(Type.TYPE_DATA, R.drawable.kairui,"开瑞"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.kaidilake,"凯迪拉克"));cars.add(new Car(Type.TYPE_DATA, R.drawable.kaiyi,"凯翼"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.kenisaike,"科尼赛克"));cars.add(new Car(Type.TYPE_DATA, R.drawable.kelaisile,"克莱斯勒"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.lanbojini,"兰博基尼"));cars.add(new Car(Type.TYPE_DATA, R.drawable.laolunshi,"劳伦士"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.laosilaisi,"莱斯莱斯"));cars.add(new Car(Type.TYPE_DATA, R.drawable.leikesasi,"雷克萨斯"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.leinuo,"雷诺"));cars.add(new Car(Type.TYPE_DATA, R.drawable.lilian,"理念"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.lifanqiche,"力帆汽车"));cars.add(new Car(Type.TYPE_DATA, R.drawable.lianhuaqiche,"莲花汽车"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.liebaoqiche,"猎豹汽车"));cars.add(new Car(Type.TYPE_DATA, R.drawable.linmu,"铃木"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.lufeng,"陆丰"));cars.add(new Car(Type.TYPE_DATA, R.drawable.luhu,"路虎"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.lutesi,"路特斯"));cars.add(new Car(Type.TYPE_DATA, R.drawable.mazida,"马自达"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.mashaladi,"玛莎拉蒂"));cars.add(new Car(Type.TYPE_DATA, R.drawable.maibahe,"迈巴赫"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.maikailun,"迈凯伦"));cars.add(new Car(Type.TYPE_DATA, R.drawable.nazhijie,"纳智捷"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.beijinjinlong,"南京金龙"));cars.add(new Car(Type.TYPE_DATA, R.drawable.ouge,"讴歌"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.oubao,"欧宝"));cars.add(new Car(Type.TYPE_DATA, R.drawable.qirui,"奇瑞"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.qichen,"启辰"));cars.add(new Car(Type.TYPE_DATA, R.drawable.qiya,"起亚"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.richan,"日产"));cars.add(new Car(Type.TYPE_DATA, R.drawable.ruilin,"瑞麟"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.sanlin,"三菱"));cars.add(new Car(Type.TYPE_DATA, R.drawable.shangqidatong,"上汽大通"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.shijue,"世爵"));cars.add(new Car(Type.TYPE_DATA, R.drawable.shuanghuan,"双环"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.shuanglong,"双龙"));cars.add(new Car(Type.TYPE_DATA, R.drawable.sibalu,"斯巴鲁"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.sikeda,"斯柯达"));cars.add(new Car(Type.TYPE_DATA, R.drawable.siweiqiche,"斯威汽车"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.tesila,"特斯拉"));cars.add(new Car(Type.TYPE_DATA, R.drawable.weilin,"威麟"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.weiziman,"威兹曼"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.woerwo,"沃尔沃"));cars.add(new Car(Type.TYPE_DATA, R.drawable.wulinqiche,"五菱汽车"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.wushiling,"五十铃"));cars.add(new Car(Type.TYPE_DATA, R.drawable.xiali,"夏利"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.xiandai,"现代"));cars.add(new Car(Type.TYPE_DATA, R.drawable.xuefolan,"雪佛兰"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.xuetielong,"雪铁龙"));cars.add(new Car(Type.TYPE_DATA, R.drawable.yemaqiche,"野马汽车"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.yiqi,"一汽"));cars.add(new Car(Type.TYPE_DATA, R.drawable.yiweike,"依维柯"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.yingfeinidi,"英菲尼迪"));cars.add(new Car(Type.TYPE_DATA, R.drawable.yinglun,"英伦"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.yongyuan,"永源"));cars.add(new Car(Type.TYPE_DATA, R.drawable.quansheng,"驭胜"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.changan,"长安"));cars.add(new Car(Type.TYPE_DATA, R.drawable.changchengqiche,"长城汽车"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.zhonghua,"中华"));cars.add(new Car(Type.TYPE_DATA, R.drawable.zhongxin,"中兴"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.zhongtai,"众泰"));
        Collections.sort(cars,new PinyinComparator());
        cars.add(0,new Car(Type.TYPE_HEADER,R.drawable.zhongxin,""));
        return cars;
    }
    public    List<Car> initGridData() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(Type.TYPE_DATA, R.drawable.aodi, "奥迪"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.dazhong, "大众"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.sikeda, "斯柯达"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.baoma, "宝马"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.bentian, "本田"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.fengtian, "丰田"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.hafo, "哈佛"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.biaozhi, "标志"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.woerwo,"沃尔沃"));
        cars.add(new Car(Type.TYPE_DATA, R.drawable.benchi,"奔驰"));
        Collections.sort(cars, new PinyinComparator());
        return cars;
    }
    public List<CarB> initBData() {
        List<CarB> cars = new ArrayList<>();
        cars.add(new CarB( R.drawable.aa1, "奥迪A1"));
        cars.add(new CarB(R.drawable.aa3, "奥迪A3"));
        cars.add(new CarB(R.drawable.aa4, "奥迪A4"));
        cars.add(new CarB(R.drawable.aa5, "奥迪A5"));
        cars.add(new CarB(R.drawable.aa6, "奥迪A6"));
        cars.add(new CarB(R.drawable.aa7, "奥迪A7"));
        cars.add(new CarB(R.drawable.aa8, "奥迪A8"));
        cars.add(new CarB(R.drawable.qq3, "奥迪Q3"));
        cars.add(new CarB(R.drawable.qq5,"奥迪Q5"));
        cars.add(new CarB(R.drawable.qq7,"奥迪Q7"));
        cars.add(new CarB(R.drawable.tt1, "奥迪TT"));
        cars.add(new CarB(R.drawable.rr8,"奥迪R8"));
        Collections.sort(cars, new PinyinComparatorB());
        return cars;
    }
}
