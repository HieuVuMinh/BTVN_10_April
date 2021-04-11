public class NhanVienParttime extends NhanVien{
    private double timeWorking;

    public NhanVienParttime(){};

    public NhanVienParttime(String id, String name, int age, String phone, String email, double timeWorking) {
        super(id, name, age, phone, email);
        this.timeWorking = timeWorking;
    }

    public double getTimeWorking() {
        return timeWorking;
    }

    public void setTimeWorking(double timeWorking) {
        this.timeWorking = timeWorking;
    }

    public double totalSalaryParttime(){
        double total = timeWorking * 1000;
        return total;
    }

    @Override
    public String toString() {
        return "NhanVienParttime{"+
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", phone=" + getPhone() +
                ", email='" + getEmail() + '\'' +
                ", timeWorking=" + timeWorking + ", total salary= " +
                totalSalaryParttime() + '}';
    }
}
