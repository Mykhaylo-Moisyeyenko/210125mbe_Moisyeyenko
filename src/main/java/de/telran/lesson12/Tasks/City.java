package de.telran.lesson12.Tasks;

public class City {

    private String title;

    public City (){
    }

    public City(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null){
            return false;
        }
        if (this == obj){
            return true;
        }
        if (!(obj instanceof City)){
            return false;
        }
        City city = (City)obj;
        if (this.title !=null && this.title.equals(city.getTitle())){
            return true;
        } else
            return false;
    }
}
