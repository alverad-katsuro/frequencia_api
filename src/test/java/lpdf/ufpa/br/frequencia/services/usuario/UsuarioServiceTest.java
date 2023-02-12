package lpdf.ufpa.br.frequencia.services.usuario;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lpdf.ufpa.br.frequencia.model.Grupo;
import lpdf.ufpa.br.frequencia.model.Usuario;
import lpdf.ufpa.br.frequencia.model.UsuarioGrupo;
import lpdf.ufpa.br.frequencia.services.grupo.GrupoService;

@SpringBootTest
public class UsuarioServiceTest {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private GrupoService grupoService;

	@Test
	public void testSave() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setUsername("admin");
		usuario.setPassword("1234");
		usuario = usuarioService.save(usuario);
		assertNotNull(usuario.getId());
	}

	@Test
	public void testAddRole() throws Exception {
		Grupo grupo = grupoService.findByNomeGrupo("ADMINISTRADOR");
		if (grupo == null) {
			grupo = new Grupo();
			grupo.setNomeGrupo("ADMINISTRADOR");
			grupo = grupoService.save(grupo);
		}
		Usuario usuario = usuarioService.findByUsername("admin");
		UsuarioGrupo usuarioGrupo = UsuarioGrupo.builder().usuario(usuario).grupo(grupo).build();
		System.out.println(usuarioGrupo.getUsuarioGrupoId());
		usuario.setUsuarioGrupos(Set.of(usuarioGrupo));
		usuario = usuarioService.save(usuario);
		assertTrue(usuario.getUsuarioGrupos().size() > 0);


	}
}
