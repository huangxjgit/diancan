package com.example.diancan;

public class MenuInfo_Dindan {
    private String paint_name;
      private String paint_time;
      private String paint_root;
     private String paint_img_root;

     public MenuInfo_Dindan(String paint_name, String paint_time,
                     String paint_root, String paint_img_root) {

                 this.paint_name = paint_name;
                 this.paint_time = paint_time;
                 this.paint_root = paint_root;
                 this.paint_img_root = paint_img_root;
             }

             public String getPaint_name() {
                  return paint_name;
             }

             public String getPaint_time() {
                 return paint_time;
             }

             public String getPaint_root() {
                 return paint_root;
             }

             public String getPaint_img_root() {
                 return paint_img_root;
             }
}
