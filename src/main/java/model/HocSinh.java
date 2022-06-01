package model;

public class HocSinh {
    private int id;
    private String name;
    private Lop lop;
    private int age;

    public HocSinh() {
    }

    public HocSinh(String name, Lop lop, int age) {
        this.name = name;
        this.lop = lop;
        this.age = age;
    }

    public HocSinh(int id, String name, Lop lop, int age) {
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
