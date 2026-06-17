
public class ActorExport {
    private int id;
    private String firstName;
    private String lastName;

    /**
     * Construtor que inicializa todos os atributos.
     *
     * @param id o identificador do ator
     * @param firstName o primeiro nome do ator
     * @param lastName o sobrenome do ator
     */
    public ActorExport(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return o id
     */
    public int getId() {
        return id;
    }

    /**
     * @return o primeiro nome
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return o sobrenome
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return string no formato: id,firstName,lastName
     */
    public String toCsvLine() {
        return id + "," + firstName + "," + lastName;
    }
}
