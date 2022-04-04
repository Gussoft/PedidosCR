package com.gussoft.pedidoscr.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numero;
    private Double total;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_mozo", nullable = false, foreignKey = @ForeignKey(name = "Fk_idmozo"))
    private Mozo mozo;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "Fk_idcliente"))
    private Cliente cliente;

    //mesa representa a platos campo mesa
    @OneToMany(mappedBy = "mesa", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}
            , fetch = FetchType.LAZY, orphanRemoval = true)// orphan permite reover un item de la lista
    private List<DetalleMesa> detalles;

    public Mesa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<DetalleMesa> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleMesa> detalles) {
        this.detalles = detalles;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
