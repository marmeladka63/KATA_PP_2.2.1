package hiber.model;

import javax.persistence.*;


@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    @OneToOne
    private User user;


    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Car(String model, int series) {

        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return
                ", model: " + model +
                        ", series: " + series;


    }
}




