package com.employee.ecommerceapi_UsingJwt.entities;

import javax.persistence.*;

@Entity
public class Role_Master {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private EmployeeRole name;

  private boolean Status;

  private boolean IsDelete;

  public Role_Master() {

  }



  public Role_Master(EmployeeRole name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EmployeeRole getName() {
    return name;
  }

  public void setName(EmployeeRole name) {
    this.name = name;
  }

  public Role_Master(Integer id, EmployeeRole name) {
    this.id = id;
    this.name = name;
  }

  public Role_Master(Integer id, EmployeeRole name, boolean status, boolean isDelete) {
    this.id = id;
    this.name = name;
    Status = status;
    IsDelete = isDelete;
  }

  public boolean isStatus() {
    return Status;
  }

  public void setStatus(boolean status) {
    Status = status;
  }

  public boolean isDelete() {
    return IsDelete;
  }

  public void setDelete(boolean delete) {
    IsDelete = delete;
  }
}