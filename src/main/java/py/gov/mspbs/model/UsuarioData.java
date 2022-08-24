package py.gov.mspbs.model;

import py.gov.mspbs.entity.Usuario;

public class UsuarioData {
    private Usuario usuario;
    private String password;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
