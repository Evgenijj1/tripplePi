package ru.sfedu.tripplepi.model;

import com.opencsv.bean.CsvBindByName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Path;

/**
 * Class Users
 */
@Root
public class Users extends Generic{

  //
  // Fields
  //
  @Element
  @CsvBindByName
  private String name;
  
  @Element
  @CsvBindByName
  private String surname;
  
  @Element(required=false)
  @CsvBindByName
  private String patronymic;
  
  @Element
  @CsvBindByName
  private String email;
  
  @Element
  @CsvBindByName
  private String phone;
  
  @Element(required=false)
  @CsvBindByName
  private boolean activation=false;
  
  @Element(required=false)
  @CsvBindByName
  private boolean block=false;
  
  @Element(required=false)
  @CsvBindByName
  private long role=1;
  
  @Element
  @CsvBindByName
  private String created_at;
  
  @Element
  @CsvBindByName
  private String updated_at;
  
  //
  // Constructors
  //
  public Users () throws InterruptedException {
      super(ClassType.USER, 1);
  }
  
  public Users(long id, String name, String surname, String patronymic, String email, String phone, boolean activation, boolean block, long role, String created_at, String updated_at) throws InterruptedException {
      super(ClassType.USER, id);
      this.name=name;
      this.surname=surname;
      this.patronymic=patronymic;
      this.email=email;
      this.phone=phone;
      this.activation=activation;
      this.block=block;
      this.role=role;
      this.created_at=created_at;
      this.updated_at=updated_at;
  }
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of name
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  /**
   * Set the value of surname
   * @param newVar the new value of surname
   */
  public void setSurname (String newVar) {
    surname = newVar;
  }

  /**
   * Get the value of surname
   * @return the value of surname
   */
  public String getSurname () {
    return surname;
  }

  /**
   * Set the value of patronymic
   * @param newVar the new value of patronymic
   */
  public void setPatronymic (String newVar) {
    patronymic = newVar;
  }

  /**
   * Get the value of patronymic
   * @return the value of patronymic
   */
  public String getPatronymic () {
    return patronymic;
  }

  /**
   * Set the value of email
   * @param newVar the new value of email
   */
  public void setEmail (String newVar) {
    email = newVar;
  }

  /**
   * Get the value of email
   * @return the value of email
   */
  public String getEmail () {
    return email;
  }

  /**
   * Set the value of phone
   * @param newVar the new value of phone
   */
  public void setPhone (String newVar) {
    phone = newVar;
  }

  /**
   * Get the value of phone
   * @return the value of phone
   */
  public String getPhone () {
    return phone;
  }

  /**
   * Set the value of activation
   * @param newVar the new value of activation
   */
  public void setActivation (boolean newVar) {
    activation = newVar;
  }

  /**
   * Get the value of activation
   * @return the value of activation
   */
  public boolean getActivation () {
    return activation;
  }

  /**
   * Set the value of block
   * @param newVar the new value of block
   */
  public void setBlock (boolean newVar) {
    block = newVar;
  }

  /**
   * Get the value of block
   * @return the value of block
   */
  public boolean getBlock () {
    return block;
  }

  /**
   * Set the value of role
   * @param newVar the new value of role
   */
  public void setRole (long newVar) {
    role = newVar;
  }

  /**
   * Get the value of role
   * @return the value of role
   */
  public long getRole () {
    return role;
  }

  /**
   * Set the value of created_at
   * @param newVar the new value of created_at
   */
  public void setCreated_at (String newVar) {
    created_at = newVar;
  }

  /**
   * Get the value of created_at
   * @return the value of created_at
   */
  public String getCreated_at () {
    return created_at;
  }

  /**
   * Set the value of updated_at
   * @param newVar the new value of updated_at
   */
  public void setUpdated_at (String newVar) {
    updated_at = newVar;
  }

  /**
   * Get the value of updated_at
   * @return the value of updated_at
   */
  public String getUpdated_at () {
    return updated_at;
  }

  //
  // Other methods
  //
  public String toString(){
      return "Class User: id="+this.id+", name="+this.name+", surname="+this.surname+", patronymic="+this.patronymic+", email="+this.email+", phone="+this.phone+", activation="+this.activation+", block="+this.block+", role="+this.role+", created_at="+this.created_at+", updated_at="+this.updated_at;
  }
    @Override
    public String getValueByFieldName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
