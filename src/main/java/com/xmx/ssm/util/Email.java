package com.xmx.ssm.util;

import org.apache.commons.mail.HtmlEmail;

public class Email {

    /**
     * https://mvnrepository.com/artifact/org.apache.commons/commons-email
     */

    private static String hostName, charset = "utf-8", iEmail, name, userName, password;
    private static int port = 25;

    /**
     * @param iEmail   发送人邮箱
     * @param name     发送人用户名
     * @param userName 授权邮箱
     * @param password 授权码
     */
    public static void sender(String iEmail, String name, String userName, String password) {
        Email.iEmail = iEmail;
        Email.name = name;
        Email.userName = userName;
        Email.password = password;
    }

    public static String getHostName() {
        return hostName;
    }

    /**
     * @param hostName SMTP服务器
     */
    public static void setHostName(String hostName) {
        Email.hostName = hostName;
    }

    public static String getCharset() {
        return charset;
    }

    /**
     * @param charset 发送的字符类型
     */
    public static void setCharset(String charset) {
        Email.charset = charset;
    }

    public static String getiEmail() {
        return iEmail;
    }

    public static void setiEmail(String iEmail) {
        Email.iEmail = iEmail;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Email.name = name;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Email.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Email.password = password;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Email.port = port;
    }

    /**
     * @param address 设置收件人
     * @param title   设置发送主题
     * @param content 设置发送内容
     * @return boolean
     */
    public static boolean sendEmail(String address, String title, String content) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setSmtpPort(port);
            email.setHostName(hostName);
            email.setCharset(charset);
            email.addTo(address);//设置收件人
            email.setFrom(iEmail, name);//发送人的邮箱为自己的，用户名可以随便填
            email.setAuthentication(userName, password);//设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
            email.setSubject(title);//设置发送主题
            email.setHtmlMsg(content);//设置发送内容
            email.send();//进行发送
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static String hint(String hint) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<base target=\"_blank\">\n" +
                "\t\t<style type=\"text/css\">\n" +
                "\t\t\t::-webkit-scrollbar {\n" +
                "\t\t\t\tdisplay: none;\n" +
                "\t\t\t}\n" +
                "\t\t</style>\n" +
                "\t\t<style id=\"cloudAttachStyle\" type=\"text/css\">\n" +
                "\t\t\t#divNeteaseBigAttach,\n" +
                "\t\t\t#divNeteaseBigAttach_bak {\n" +
                "\t\t\t\tdisplay: none;\n" +
                "\t\t\t}\n" +
                "\t\t</style>\n" +
                "\t\t<style id=\"blockquoteStyle\" type=\"text/css\">\n" +
                "\t\t\tblockquote {\n" +
                "\t\t\t\tdisplay: none;\n" +
                "\t\t\t}\n" +
                "\t\t</style>\n" +
                "\t\t<style type=\"text/css\">\n" +
                "\t\t\tbody {\n" +
                "\t\t\t\tfont-size: 14px;\n" +
                "\t\t\t\tfont-family: arial, verdana, sans-serif;\n" +
                "\t\t\t\tline-height: 1.666;\n" +
                "\t\t\t\tpadding: 0;\n" +
                "\t\t\t\tmargin: 0;\n" +
                "\t\t\t\toverflow: auto;\n" +
                "\t\t\t\twhite-space: normal;\n" +
                "\t\t\t\tword-wrap: break-word;\n" +
                "\t\t\t\tmin-height: 100px\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\ttd,\n" +
                "\t\t\tinput,\n" +
                "\t\t\tbutton,\n" +
                "\t\t\tselect,\n" +
                "\t\t\tbody {\n" +
                "\t\t\t\tfont-family: Helvetica, 'Microsoft Yahei', verdana\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\tpre {\n" +
                "\t\t\t\twhite-space: pre-wrap;\n" +
                "\t\t\t\twhite-space: -moz-pre-wrap;\n" +
                "\t\t\t\twhite-space: -pre-wrap;\n" +
                "\t\t\t\twhite-space: -o-pre-wrap;\n" +
                "\t\t\t\tword-wrap: break-word;\n" +
                "\t\t\t\twidth: 95%\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\tth,\n" +
                "\t\t\ttd {\n" +
                "\t\t\t\tfont-family: arial, verdana, sans-serif;\n" +
                "\t\t\t\tline-height: 1.666\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\timg {\n" +
                "\t\t\t\tborder: 0\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\theader,\n" +
                "\t\t\tfooter,\n" +
                "\t\t\tsection,\n" +
                "\t\t\taside,\n" +
                "\t\t\tarticle,\n" +
                "\t\t\tnav,\n" +
                "\t\t\thgroup,\n" +
                "\t\t\tfigure,\n" +
                "\t\t\tfigcaption {\n" +
                "\t\t\t\tdisplay: block\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\tblockquote {\n" +
                "\t\t\t\tmargin-right: 0px\n" +
                "\t\t\t}\n" +
                "\t\t</style>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<table width=\"700\" border=\"0\" align=\"center\" cellspacing=\"0\" style=\"width:700px;\">\n" +
                "\t\t\t<tbody>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t<div style=\"width:700px;margin:0 auto;border-bottom:1px solid #ccc;margin-bottom:30px;\">\n" +
                "\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"700\" height=\"39\" style=\"font:12px Tahoma, Arial, 宋体;\">\n" +
                "\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td width=\"210\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div style=\"width:680px;padding:0 10px;margin:0 auto;\">\n" +
                "\t\t\t\t\t\t\t<div style=\"line-height:1.5;font-size:14px;margin-bottom:25px;color:#4d4d4d;\">\n" +
                "\t\t\t\t\t\t\t\t<strong style=\"display:block;margin-bottom:15px;\">尊敬的用户：<span style=\"color:#f60;font-size: 16px;\"></span>您好！</strong>\n" +
                "\t\t\t\t\t\t\t\t<strong style=\"display:block;margin-bottom:15px;\">\n" +
                "\t\t\t\t\t\t\t\t\t<span style=\"color: red\">");
        stringBuffer.append(hint);
        stringBuffer.append("</span>，请妥善保管您的账号信息！\n" +
                "\t\t\t\t\t\t\t\t</strong>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div style=\"width:700px;margin:0 auto;\">\n" +
                "\t\t\t\t\t\t\t<div style=\"padding:10px 10px 0;border-top:1px solid #ccc;color:#747474;margin-bottom:20px;line-height:1.3em;font-size:12px;\">\n" +
                "\t\t\t\t\t\t\t\t<p>此为系统邮件，请勿回复<br />\n" +
                "\t\t\t\t\t\t\t\t\t请保管好您的邮箱，避免账号被他人盗用\n" +
                "\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t<p>XXXXXX团队</p>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</tbody>\n" +
                "\t\t</table>\n" +
                "\t</body>\n" +
                "</html>\n");

        return stringBuffer.toString();
    }

    /**
     * @param hint     提示
     * @param authCode 验证码
     * @return String
     */
    public static String text(String hint, String authCode) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t    <base target=\"_blank\" />\n" +
                "\t    <style type=\"text/css\">::-webkit-scrollbar{ display: none; }</style>\n" +
                "\t    <style id=\"cloudAttachStyle\" type=\"text/css\">#divNeteaseBigAttach, #divNeteaseBigAttach_bak{display:none;}</style>\n" +
                "\t    <style id=\"blockquoteStyle\" type=\"text/css\">blockquote{display:none;}</style>\n" +
                "\t    <style type=\"text/css\">\n" +
                "\t        body{font-size:14px;font-family:arial,verdana,sans-serif;line-height:1.666;padding:0;margin:0;overflow:auto;white-space:normal;word-wrap:break-word;min-height:100px}\n" +
                "\t        td, input, button, select, body{font-family:Helvetica, 'Microsoft Yahei', verdana}\n" +
                "\t        pre {white-space:pre-wrap;white-space:-moz-pre-wrap;white-space:-pre-wrap;white-space:-o-pre-wrap;word-wrap:break-word;width:95%}\n" +
                "\t        th,td{font-family:arial,verdana,sans-serif;line-height:1.666}\n" +
                "\t        img{ border:0}\n" +
                "\t        header,footer,section,aside,article,nav,hgroup,figure,figcaption{display:block}\n" +
                "\t        blockquote{margin-right:0px}\n" +
                "\t    </style>\n" +
                "\t</head>\n" +
                "\t<body tabindex=\"0\" role=\"listitem\">\n" +
                "\t<table width=\"700\" border=\"0\" align=\"center\" cellspacing=\"0\" style=\"width:700px;\">\n" +
                "\t    <tbody>\n" +
                "\t    <tr>\n" +
                "\t        <td>\n" +
                "\t            <div style=\"width:700px;margin:0 auto;border-bottom:1px solid #ccc;margin-bottom:30px;\">\n" +
                "\t                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"700\" height=\"39\" style=\"font:12px Tahoma, Arial, 宋体;\">\n" +
                "\t                    <tbody><tr><td width=\"210\"></td></tr></tbody>\n" +
                "\t                </table>\n" +
                "\t            </div>\n" +
                "\t            <div style=\"width:680px;padding:0 10px;margin:0 auto;\">\n" +
                "\t                <div style=\"line-height:1.5;font-size:14px;margin-bottom:25px;color:#4d4d4d;\">\n" +
                "\t                    <strong style=\"display:block;margin-bottom:15px;\">尊敬的用户：<span style=\"color:#f60;font-size: 16px;\"></span>您好！</strong>\n" +
                "\t                    <strong style=\"display:block;margin-bottom:15px;\">\n" +
                "\t                        您正在进行<span style=\"color: red\">");
        //提示
        stringBuffer.append(hint);
        stringBuffer.append("</span>操作，请在验证码输入框中输入：<span style=\"color:#f60;font-size: 24px\">");
        //验证码
        stringBuffer.append(authCode);
        stringBuffer.append("</span>，以完成操作。\n" +
                "\t                    </strong>\n" +
                "\t                </div>\n" +
                "\t                <div style=\"margin-bottom:30px;\">\n" +
                "\t                    <small style=\"display:block;margin-bottom:20px;font-size:12px;\">\n" +
                "\t                        <p style=\"color:#747474;\">\n" +
                "\t                            注意：此操作可能会修改您的密码、登录邮箱或绑定手机。如非本人操作，请及时登录并修改密码以保证帐户安全\n" +
                "\t                            <br>（工作人员不会向你索取此验证码，请勿泄漏！)\n" +
                "\t                        </p>\n" +
                "\t                    </small>\n" +
                "\t                </div>\n" +
                "\t            </div>\n" +
                "\t            <div style=\"width:700px;margin:0 auto;\">\n" +
                "\t                <div style=\"padding:10px 10px 0;border-top:1px solid #ccc;color:#747474;margin-bottom:20px;line-height:1.3em;font-size:12px;\">\n" +
                "\t                    <p>此为系统邮件，请勿回复<br>\n" +
                "\t                        请保管好您的邮箱，避免账号被他人盗用\n" +
                "\t                    </p>\n" +
                "\t                    <p>XXXXXX团队</p>\n" +
                "\t                </div>\n" +
                "\t            </div>\n" +
                "\t        </td>\n" +
                "\t    </tr>\n" +
                "\t    </tbody>\n" +
                "\t</table>\n" +
                "\t</body>\n" +
                "</html>\n" +
                "\n");

        return stringBuffer.toString();
    }
}
