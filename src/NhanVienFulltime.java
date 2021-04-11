public class NhanVienFulltime extends NhanVien{
    private double salary;
    private double reward;
    private double penalty;

    public NhanVienFulltime(){};

    public NhanVienFulltime(String id, String name, int age, String phone, String email, double salary, double reward, double penalty) {
        super(id, name, age, phone, email);
        this.salary = salary;
        this.reward = reward;
        this.penalty = penalty;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public double totalSalaryFullime(){
        double total = salary + (reward - penalty);
        return total;
    }

    @Override
    public String toString() {
        return "NhanVienFulltime{" +
                "id='" + getId() + '\'' + ", name='" + getName() + '\'' + ", age=" + getAge() +
                ", phone=" + getPhone() + ", email='" + getEmail() + '\'' + ", salary=" + salary +
                ", reward=" + reward + ", penalty=" + penalty + ", total salary= " +
                totalSalaryFullime() + '}';
    }
}
