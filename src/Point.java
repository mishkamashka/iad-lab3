import javax.persistence.*;

@Entity
@Table(name= "Points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "r", nullable = false)
    private Double r;
    @Column(name = "x", nullable = false)
    private Double x;
    @Column(name = "y", nullable = false)
    private Double y;
    @Column(name = "ch", nullable = false)
    private Boolean ischeck;

    public Point (Double r, Double x, Double y, Boolean ischeck){
        this.r = r;
        this.x = x;
        this.y = y;
        this.ischeck = ischeck;
    }


    public Double getR() {
        return r/2;
    }
    public void setR(Double r) {
        this.r = r;
    }

    public Double getX() {
        return x/10;
    }
    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }
    public void setY(Double y) {
        this.y = y;
    }

    public Boolean getIsCheck() {
        return ischeck;
    }
    public void setIsCheck(Boolean ischeck) {
        this.ischeck = ischeck;
    }

}
