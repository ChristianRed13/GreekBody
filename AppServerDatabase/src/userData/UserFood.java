package userData;

import java.io.Serializable;
import javax.persistence.*;

import foodData.Food;


/**
 * The persistent class for the user_food database table.
 * 
 */
@Entity
@Table(name="user_food")
@NamedQuery(name="UserFood.findAll", query="SELECT u FROM UserFood u")
public class UserFood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user_food")
	private int id_user_food;

	//bi-directional many-to-one association to GreekUser
	@ManyToOne	
	@JoinColumn(name="id_food")
	private Food id_food;

	//bi-directional many-to-one association to GreekUser
	@ManyToOne
	@JoinColumn(name="id_user")
	private GreekUser id_user;

	public UserFood() {
	}
	
	

	public UserFood(Food id_food, GreekUser id_user) {
		this.id_food = id_food;
		this.id_user = id_user;
	}



	public int getIdUserFood() {
		return this.id_user_food;
	}

	public void setIdUserFood(int idUserFood) {
		this.id_user_food = idUserFood;
	}

	public Food getIdFood() {
		return this.id_food;
	}

	public void setIdFood(Food idFood) {
		this.id_food = idFood;
	}

	public GreekUser getGreekUser() {
		return this.id_user;
	}

	public void setGreekUser(GreekUser greekUser) {
		this.id_user = greekUser;
	}
	

}