package statePattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

    public static void main(String[] args) {
        String pattern="<(S*?)[^>]*>.*?|<.*? />";
        String url="<a class=''>你好,</a><br/><a class=''>你好,</a><br/>";
        boolean matches = Pattern.matches(pattern, url);
        System.out.println(matches);
        Matcher matcher = Pattern.compile(pattern).matcher(url);
//        if(matcher.find()){
//            System.out.println(true);
//            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//        }

        while (matcher.find()){
            String targetTag=matcher.group();
            String tag=targetTag;
            if(targetTag.startsWith("</") || targetTag.endsWith("/>")){
                continue;
            }
            System.out.println(tag);
            targetTag=targetTag.replaceAll("class='.*?'","").replaceAll("class=\".*?\"","");
            String className="hidden";
            targetTag = targetTag.replace(">", " class='" + className + "'>");
            url=url.replace(tag,targetTag);
        }
        System.out.println(url);
    }

    private static void regTest1() {
        //提取td元素里的内容
        String str="<table><tr><td>hello world</td><td>hello regex</td></tr></table>";

        //贪婪模式  * + {n,} 默认情况是贪婪模式匹配
        System.out.println("贪婪模式");
        //编译正则表达式到模式对象
        Pattern p=Pattern.compile("(<td>[^<]*</td>)");
        //得到匹配器
        Matcher m=p.matcher(str);
        //通过find方法查找匹配，找到就返回true，否则返回false
        while(m.find()){
            //通过group方法获取前面find查找到的子字符串，start、end方法获取子字符串开始和结束位置
            System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
        }

        //非贪婪模式，?跟在 * + {n,} 等的后面时，表示非贪婪模式，注意和子表达式后面的?区分开，子表达式后的?表示匹配0次或1次
        System.out.println("非贪婪模式");
        p=Pattern.compile("<td>.*?</td>");
        m=p.matcher(str);
        while(m.find()){
            System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
        }
    }

    private static void htmlTest() {
        String url="<div id=\"head\" class=\"s-skin-hasbg white-logo s-opacity-90\"><div id=\"s_top_wrap\" class=\"s-top-wrap\" style=\"left: 0px;\"><div class=\"s-top-nav\"></div><div class=\"s-center-box\"></div></div><div id=\"s_upfunc_menus\" class=\"s-upfunc-menus\"><!-- <div class=\"s-weather-wrapper\"></div> --><div class=\"s-weather-wrapper\"><div id=\"s_mod_weather\" class=\"s-mod-weather s-isindex-wrap hide-unknow-city \"><div class=\"weather-mod\"><a class=\"city-wather\" href=\"//www.baidu.com/s?tn=baidutop10&amp;rsv_idx=2&amp;wd=%E6%9D%AD%E5%B7%9E%E5%A4%A9%E6%B0%94%E9%A2%84%E6%8A%A5\" target=\"_blank\"><div class=\"show-weather\"><span class=\"show-city\"><em class=\"show-city-name\" data-key=\"杭州\">杭州：</em></span><span class=\"show-icon\"><span class=\"weather-icon\" style=\"background-image:url(https://dss2.bdstatic.com/kfoZeXSm1A5BphGlnYG/icon/weather/aladdin/png_18/a2.png);*background-image:none;*filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=https://dss2.bdstatic.com/kfoZeXSm1A5BphGlnYG/icon/weather/aladdin/png_18/a2.png, enabled=true,sizingMethod=\" crop\")\";=\"\"></span><em class=\"show-icon-temp\">10℃</em></span><span class=\"show-temp\"></span></div><div class=\"show-pollution \"><span class=\"show-airParm polution-level-10\"><em class=\"show-polution-name\">良</em><em class=\"show-polution-num\">91</em></span><span class=\"show-vertical\">|</span></div></a></div><div class=\"unknown-city\"><span class=\"unknown-icon\"></span><span class=\"unknown-text\">查看天气信息，</span><span class=\"unknown-setting\">设置城市</span></div></div></div><div class=\"s-icons is-lite\" id=\"s_icons\"><a class=\"s-skin\" href=\"#\" onclick=\"return false;\" data-tid=\"2001\" title=\"换肤\"><span class=\"s-icon s-icon-skin\"></span><span class=\"title\">换肤</span></a><a class=\"s-msg\" href=\"#\" onclick=\"return false;\" data-tid=\"2002\" title=\"消息\"><span class=\"s-icon s-icon-msg\"></span><span class=\"title\">消息</span></a><em class=\"s-icon s-icon-line\" href=\"#\" onclick=\"return false;\"></em><div class=\"s-mod-msg-shadow\" id=\"s_mod_msg_shadow\" style=\"display:none;\"></div><div id=\"s_mod_msg\" class=\"s-mod-msg\" style=\"display:none;\"><span class=\"menu-arrow\"><em></em></span><div class=\"s-mod-msg-bg\"><div class=\"msg-area\" id=\"s_msg_content\"></div></div></div><div class=\"s-mod-treasure\" id=\"s_treasure\" style=\"display:none;\"></div><div class=\"s-opacity-tip\" id=\"s_opacity_tip\" style=\"display:none;\"></div></div></div><div id=\"u_sp\" class=\"s-isindex-wrap s-sp-menu\"><a href=\"http://news.baidu.com\" target=\"_blank\" class=\"mnav\">新闻</a><a href=\"https://www.hao123.com\" target=\"_blank\" class=\"mnav\">hao123</a><a href=\"http://map.baidu.com\" target=\"_blank\" class=\"mnav\">地图</a><a href=\"http://v.baidu.com\" target=\"_blank\" class=\"mnav\">视频</a><a href=\"http://tieba.baidu.com\" target=\"_blank\" class=\"mnav\">贴吧</a><a href=\"http://xueshu.baidu.com\" target=\"_blank\" class=\"mnav\">学术</a><a id=\"s_username_top\" class=\"s-user-name-top\" data-tid=\"2004\" href=\"http://i.baidu.com/\" target=\"_blank\"><span class=\"user-name\">走在冷风中的伱</span></a><a id=\"s_usersetting_top\" href=\"javascript:;\" name=\"tj_settingicon\" class=\"pf s-user-setting-top\"><span class=\"setting-text\">设置</span></a><a href=\"http://www.baidu.com/more/\" name=\"tj_briicon\" class=\"s_bri\" target=\"_blank\">更多产品</a><div id=\"s_user_name_menu\" class=\"s-isindex-wrap s-user-set-menu menu-top\" style=\"display:none;\"><div><a href=\"http://i.baidu.com/center\" target=\"_blank\" data-tid=\"1000\">个人中心</a><a href=\"http://passport.baidu.com/\" data-tid=\"1001\" target=\"_blank\">帐号设置</a><a class=\"quit\" style=\"overflow:hidden\" href=\"#\" onclick=\"return false;\">退出</a></div><span class=\"menu-arrow\"><em></em></span></div><div id=\"s_user_setting_menu\" class=\"s-isindex-wrap s-user-set-menu menu-top\" style=\"display:none;\"><div><a href=\"//www.baidu.com/gaoji/preferences.html\" target=\"_blank\">搜索设置</a><a href=\"//www.baidu.com/gaoji/advanced.html\" target=\"_blank\">高级搜索</a><a href=\"http://i.baidu.com/my/history?from=index\" target=\"_blank\">搜索历史</a><a class=\"s-feedback\" style=\"overflow:hidden\" href=\"#\" onclick=\"return false;\">意见反馈</a></div><span class=\"menu-arrow\"><em></em></span></div></div><style>.s_lg_img_gold_showre {display: none !important;}@media (-webkit-min-device-pixel-ratio: 2),(min--moz-device-pixel-ratio: 2),(-o-min-device-pixel-ratio: 2),(min-device-pixel-ratio: 2){.s_lg_img_gold_show {display: none !important;}.s_lg_img_gold_showre {display: inline !important;}}</style><div class=\"clear\"></div><div id=\"head_wrapper\" class=\"s-isindex-wrap head_wrapper s-title-img  s-ps-islite\"><link rel=\"stylesheet\" href=\"https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/static/protocol/https/soutu/css/soutu.css\" type=\"text/css\" data-for=\"result\"><div id=\"s_fm\" class=\"s_form\"><div class=\"s_form_wrapper soutu-env-mac soutu-env-newindex\" id=\"s_form_wrapper\"><div id=\"lg\" class=\"s-p-top\"><img id=\"s_lg_img\" class=\"s_lg_img_gold_show\" src=\"//www.baidu.com/img/labadong_9f901c0eb1a677ad32efe1d024e12bac.gif\" width=\"270\" height=\"129\" usemap=\"#mp\" title=\"\" cursor=\"default\"><img id=\"s_lg_img_new\" class=\"s_lg_img_gold_showre\" src=\"//www.baidu.com/img/labadong_9f901c0eb1a677ad32efe1d024e12bac.gif\" width=\"270\" height=\"129\" usemap=\"#mp\" title=\"\" cursor=\"default\"><map name=\"mp\" id=\"s_mp\"><area style=\"cursor:pointer;outline:none;\" shape=\"rect\" coords=\"0,0,270,129\" href=\"//www.baidu.com/s?wd=%e8%85%8a%e5%85%ab&amp;sa=ire_dl_gh_logo&amp;rsv_dl=igh_logo_pc\" target=\"_blank\" title=\"过了腊八就是年\" onmousedown=\"return ns_c({'fm':'behs','tab':'bdlogo'})\"></map></div><a href=\"/\" id=\"result_logo\" onmousedown=\"return c({'fm':'tab','tab':'logo'})\"><img class=\"s_lg_img_gold_show\" src=\"https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top-e3b63a0b1b.png\" alt=\"到百度首页\" title=\"到百度首页\"><img class=\"s_lg_img_gold_showre\" src=\"//www.baidu.com/img/baidu_resultlogo@2.png\" alt=\"到百度首页\" title=\"到百度首页\"></a><form name=\"f\" id=\"form\" action=\"/s\" class=\"fm\" onsubmit=\"javascript:F.call('ps/sug','pssubmit');\"><span id=\"s_kw_wrap\" class=\"bg s_ipt_wr quickdelete-wrap\"><span class=\"ipt_rec\" style=\"display: block;\"></span><span class=\"soutu-btn\"></span><input type=\"text\" class=\"s_ipt\" name=\"wd\" id=\"kw\" maxlength=\"100\" autocomplete=\"off\"><a href=\"javascript:;\" id=\"quickdelete\" title=\"清空\" class=\"quickdelete\" style=\"top: 0px; right: 0px; display: none;\"></a></span><input type=\"hidden\" name=\"rsv_spt\" value=\"1\"><input type=\"hidden\" name=\"rsv_iqid\" value=\"0x9dac7c0b004acb5f\"><input type=\"hidden\" name=\"issp\" value=\"1\"><input type=\"hidden\" name=\"f\" value=\"8\"><input type=\"hidden\" name=\"rsv_bp\" value=\"1\"><input type=\"hidden\" name=\"rsv_idx\" value=\"2\"><input type=\"hidden\" name=\"ie\" value=\"utf-8\"><input type=\"hidden\" name=\"rqlang\" value=\"\"><input type=\"hidden\" name=\"tn\" value=\"baiduhome_pg\"><input type=\"hidden\" name=\"ch\" value=\"\"><span class=\"btn_wr s_btn_wr bg\" id=\"s_btn_wr\"><input type=\"submit\" value=\"百度一下\" id=\"su\" class=\"btn self-btn bg s_btn\"></span><span class=\"tools\"><span id=\"mHolder\"><div id=\"mCon\"><span>输入法</span></div><ul id=\"mMenu\"><li><a href=\"javascript:;\" name=\"ime_hw\">手写</a></li><li><a href=\"javascript:;\" name=\"ime_py\">拼音</a></li><li class=\"ln\"></li><li><a href=\"javascript:;\" name=\"ime_cl\">关闭</a></li></ul></span><span class=\"bd_bear_home\"></span></span><input type=\"hidden\" name=\"rsv_dl\" value=\"ib\"><input type=\"hidden\" name=\"rsv_enter\" value=\"1\"></form></div></div><div id=\"u\"><a class=\"toindex\" href=\"/\">百度首页</a><span class=\"toindex\"></span><a id=\"imsg\" href=\"http://www.baidu.com/#\" onmousedown=\"return user_c({'fm':'set','tab':'imsg','login':'1'})\">消息</a><a href=\"javascript:;\" name=\"tj_settingicon\" class=\"pf\">设置<i class=\"c-icon c-icon-triangle-down\"></i></a><a href=\"http://i.baidu.com\" id=\"user\" class=\"username\">走在冷风中的伱<i class=\"c-icon\"></i></a></div><div id=\"s_lm_wrap\" class=\"s_lm_hide s-isindex-wrap\"><div id=\"lm\"></div></div><p class=\"s-skin-lm s-isindex-wrap\"></p></div><div id=\"s_wrap\" class=\"s-isindex-wrap\"><div id=\"s_main\" class=\"main clearfix\"></div><textarea id=\"s_sync_data\" style=\"display:none;\"></textarea></div><div id=\"bottom_layer\" class=\"s-bottom-layer\"><div class=\"s-bottom-layer-left\"><p class=\"lh\"><a href=\"//www.baidu.com/cache/sethelp/index.html\" target=\"_blank\">设为首页</a></p><p class=\"lh\"><a href=\"//home.baidu.com\" target=\"_blank\">关于百度</a></p><p class=\"lh\"><a href=\"http://ir.baidu.com\" target=\"_blank\">About Baidu</a></p><p class=\"lh\"><a href=\"http://e.baidu.com/?refer=888\" target=\"_blank\">百度推广</a></p><p class=\"lh\"><a href=\"//www.baidu.com/duty\" target=\"_blank\">使用百度前必读</a></p><p class=\"lh\"><a href=\"//help.baidu.com/newadd?prod_id=1&amp;category=4\" target=\"_blank\">意见反馈</a></p><p class=\"lh\"><a href=\"//help.baidu.com\" target=\"_blank\">帮助中心</a></p></div><div class=\"s-bottom-layer-right hide-card\"><span class=\"lh\">©2020&nbsp;Baidu&nbsp;</span><span class=\"lh\">(京)-经营性-2017-0020</span><a href=\"http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11000002000001\" target=\"_blank\"><span class=\"lh s-bottom-recordcode\">京公网安备11000002000001号</span></a><span class=\"lh\">京ICP证030173号</span></div></div></div>";
        url="<a class=''>你好,</a><br/><a class=''>你好,</a><br/>";
        String pattern="(<.*?>)";
//        <([^>]*)?>
        //是否含有
        boolean matches = Pattern.matches(pattern, url);
        System.out.println(matches);
        Matcher matcher = Pattern.compile(pattern).matcher(url);
//        if(matcher.find()){
//            System.out.println(true);
//            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//        }

        while (matcher.find()){
            String targetTag=matcher.group();
            String tag=targetTag;
            if(targetTag.startsWith("</") || targetTag.endsWith("/>")){
                continue;
            }
            System.out.println(tag);
            targetTag=targetTag.replaceAll("class='.*?'","").replaceAll("class=\".*?\"","");
            String className="hidden";
            targetTag = targetTag.replace(">", " class='" + className + "'>");
            url=url.replace(tag,targetTag);
        }
        System.out.println(url);
    }
}
