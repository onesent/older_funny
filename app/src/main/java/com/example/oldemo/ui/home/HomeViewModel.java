package com.example.oldemo.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Info_Detail>> e_list;
    private MutableLiveData<ArrayList<Info_Detail>> z_list;
    private MutableLiveData<ArrayList<Info_Detail>> k_list;

    public static final int INFO_E = 1;
    public static final int INFO_Z = 2;
    public static final int INFO_K = 3;
    public HomeViewModel() {
        e_list = new MutableLiveData<>();
        e_list.setValue(new ArrayList<Info_Detail>());

        z_list = new MutableLiveData<>();
        z_list.setValue(new ArrayList<Info_Detail>());

        k_list = new MutableLiveData<>();
        k_list.setValue(new ArrayList<Info_Detail>());
        buildInfo();
    }

    public ArrayList<Info_Detail> get_info(int info_switch) {
        ArrayList<Info_Detail> info = new ArrayList<>();
        switch(info_switch){
            case INFO_E:
                if(!e_list.getValue().isEmpty()){
                    info =  e_list.getValue();
                }
                break;
            case INFO_Z:
                if(!z_list.getValue().isEmpty()){
                    info =  z_list.getValue();
                }
                break;
            case INFO_K:
                if(!k_list.getValue().isEmpty()){
                    info =  k_list.getValue();
                }
                break;
            default:
                break;
        }
        return info;
    }
    //构造info
    public void buildInfo(){
        String[] em_c = new String[]{"阿里","腾讯","网易","阿里","腾讯","网易","阿里","腾讯","网易"};
        String[] em_p = new String[]{"高管","文员","人力","档案员","文员","人力","程序员","文员","人力"};
        String[] zm_c = new String[]{"蓝天志愿机构","海天志愿机构","广州志愿机构"};
        String[] zm_p = new String[]{"义教","爱心慰问老人","扶贫项目"};
        String[] km_c = new String[]{"增城养老中心","天逸养老中心","哗哗养老中心"};
        String[] km_p = new String[]{"111","231","95"};

        ArrayList<Info_Detail> info1_cache = new ArrayList<>();
        ArrayList<Info_Detail> info2_cache = new ArrayList<>();
        ArrayList<Info_Detail> info3_cache = new ArrayList<>();
        for(int i = 0;i < em_c.length;++i){
            info1_cache.add(new Info_Detail(em_c[i],em_p[i],em_c[i] + "招" + em_p[i],"月薪 10k-15k"));
        }
        for(int i = 0;i < zm_c.length;++i){
            info2_cache.add(new Info_Detail(zm_c[i],zm_p[i],zm_c[i] + "寻" + zm_p[i],"志愿时长 2小时"));
        }
        for(int i = 0;i < km_c.length;++i){
            info3_cache.add(new Info_Detail(km_c[i],km_p[i],km_c[i] + "剩余床位" + km_p[i],"设备齐全.环境优"));
        }
        e_list.setValue(info1_cache);
        z_list.setValue(info2_cache);
        k_list.setValue(info3_cache);
    }
    public void initInf(){
        e_list.setValue(new ArrayList<Info_Detail>());
        z_list.setValue(new ArrayList<Info_Detail>());
        k_list.setValue(new ArrayList<Info_Detail>());
    }
}
class Info_Detail{
    protected String e_c;
    protected String e_p;
    protected String e_i;
    protected String e_m;
    public Info_Detail(String c,String p,String i,String m){
        e_c = c;
        e_p = p;
        e_i = i;
        e_m = m;
    }
    public String getCompany(){
        return e_c;
    }
    public String getPofession(){
        return e_p;
    }
    public String getInfo(){
        return e_i;
    }
    public String getMoney(){
        return e_m;
    }
}
