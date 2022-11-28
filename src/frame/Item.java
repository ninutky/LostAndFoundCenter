package frame;

import java.sql.Date;

public class Item {
   int id;
   boolean itype;
   String name;
   String place;
   Date date;
   String ano;
   String img;

   /*
    * public Item(int id, boolean itype, String name, String place, Date date,
    * String ano, String img) { this.id = id; this.itype = itype; this.name = name;
    * this.place = place; this.date = date; this.ano = ano; this.img = img; }
    */

   public int getId() {
      return id;
   }
   
   public void setId(int id) {
      this.id = id;
   }
   
   public boolean isItype() {
      return itype;
   }

   public void setItype(boolean itype) {
      this.itype = itype;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPlace() {
      return place;
   }

   public void setPlace(String place) {
      this.place = place;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public String getAno() {
      return ano;
   }

   public void setAno(String ano) {
      this.ano = ano;
   }

   public String getImg() {
      return img;
   }

   public void setImg(String img) {
      this.img = img;
   }

}