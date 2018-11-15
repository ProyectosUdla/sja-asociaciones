package mx.com.gm.sga.eis;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Usuario;

@Local
public interface UsuarioDao {

	public List<Usuario> findAllUsuarios();

	public Usuario findUsuarioById(Usuario usuario);

	public void insertUsuario(Usuario usuario);

	public void updateUsuario(Usuario usuario);

	public void deleteUsuario(Usuario usuario);
}