public class Customer extends Person
{
  private long phone;
  private Email email;
  private DriversLicense driversLicense;

  public Customer(Name name, MyDate birthday, char gender, long phone, Email email, DriversLicense driversLicense){
    super(name, birthday, gender);
    this.phone = phone;
    this.email = email;
    this.driversLicense = driversLicense;
  }

  public Customer(Name name, MyDate birthday, char gender, long phone){
    super(name, birthday, gender);
    this.phone = phone;
    this.email = null;
    this.driversLicense = null;
  }

  public Customer(Name name, char gender, long phone){
    super(name, gender);
    this.phone = phone;
    this.email = null;
    this.driversLicense = null;
  }

  public long getPhone()
  {
    return phone;
  }

  public Email getEmail()
  {
    return email;
  }

  public DriversLicense getDriversLicense()
  {
    return driversLicense;
  }

  public int getDriversLicenseNumber()
  {
    return driversLicense.getNumber();
  }

  public void setPhone(long phone)
  {
    this.phone = phone;
  }

  public void setEmail(Email email)
  {
    this.email = email;
  }

  public void setDriversLicense(DriversLicense driversLicense)
  {
    this.driversLicense = driversLicense;
  }
}