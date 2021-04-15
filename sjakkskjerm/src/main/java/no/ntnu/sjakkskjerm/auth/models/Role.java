package no.ntnu.sjakkskjerm.models;


import javax.persistence.*;

@Entity
@Table(name = "s")
public class Role {

    @Id
    @SequenceGenerator(name = "role_sequence", sequenceName = "role_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private  RoleEnum name;

    public Role() {

    }

    public Role(RoleEnum name) {
        this.name = name;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
