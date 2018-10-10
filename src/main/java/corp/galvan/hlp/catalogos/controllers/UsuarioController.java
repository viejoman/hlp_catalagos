package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.Usuario;
import corp.galvan.hlp.catalogos.model.UsuarioModel;
import corp.galvan.hlp.catalogos.services.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.*;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService _usuarioService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Usuario registerUser(@RequestBody Usuario p__user) {
        p__user.setPasswd(p__user.getCve_acceso_aux().getBytes());
        p__user = _usuarioService.saveOrUpdate(p__user);
        return p__user;
    }

    @RequestMapping(value = "/registerlist", method = RequestMethod.POST)
    public Boolean registerUser(@RequestBody List<Usuario> p__listuser) {

        for (Usuario _user : p__listuser) {
            _user.setPasswd(_user.getCve_acceso_aux().getBytes());
            _user = _usuarioService.saveOrUpdate(_user);
        }

        return true;
    }

    @RequestMapping(value = "/updatecveacceso", method = RequestMethod.POST)
    public Boolean updatePassUser(@RequestBody Usuario p__user) {

        return _usuarioService.update_cve_acceso(p__user);

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UsuarioModel login(@RequestBody Usuario login) throws ServletException {

        List<Usuario> _listUsuario = new ArrayList<Usuario>();

        UsuarioModel _userModel = new UsuarioModel();
        String jwtToken = "";

        if (login.getUsuario() == null || login.getPasswd() == null) {
            _userModel.setSuccess(false);
            _userModel.setCode("400");
            _userModel.setMessage("Por favor, introduzca el usuario y password");
            //throw new ServletException("Por favor, introduzca el usuario y password");
            return _userModel;
        }

        String username = login.getUsuario();
        String password = DigestUtils.sha256Hex(login.getPasswd());

        Usuario user = _usuarioService.findByUsuario(username);

        if (user == null) {
            _userModel.setSuccess(false);
            _userModel.setCode("400");
            _userModel.setMessage("Usuario no valido o no se encuentra registrado.");
            //throw new ServletException("Usuario no valido o no se encuentra registrado.");
            return _userModel;
        }

        byte[] pwd = user.getPasswd();

        if (!password.equals(pwd)) {
            _userModel.setSuccess(false);
            _userModel.setCode("400");
            _userModel.setMessage("Credenciales incorrectas. Por favor revise el usuario y password.");
            //throw new ServletException("Credenciales incorrectas. Por favor revise el usuario y password.");

        } else {

            jwtToken = Jwts.builder()
                    .setSubject(username)
                    .claim("roles", "user")
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "s3Cr3Tk3y")
                    .compact();

            _userModel.setSuccess(true);
            _userModel.setCode("200");
            _userModel.setMessage("Login Correcto!");
            _listUsuario.add(user);
            _userModel.setData(_listUsuario);
        }


        return _userModel;

    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public UsuarioModel getUsuarioById(@PathVariable("id") Long p__id) {

        UsuarioModel _userModel = new UsuarioModel();

        List<Usuario> _listUsuario = new ArrayList<>();

                Usuario _user = _usuarioService.getById(p__id);
        if (_user == null) {
            _userModel.setSuccess(false);
            _userModel.setCode("400");
            _userModel.setMessage("No existe el Usuario");
        } else {
            _userModel.setSuccess(true);
            _userModel.setCode("200");
            _userModel.setMessage("Usuario OKAY!");
            _listUsuario.add(_user);
            _userModel.setData(_listUsuario);
        }

        return _userModel;
    }

    @RequestMapping(value = "/hlp/{idgrupo}/show/sucursal/{idsucursal}", method = RequestMethod.GET)
    public UsuarioModel getUsuariosHLPByGrupoSucursal(@PathVariable long idgrupo, @PathVariable long idsucursal)
    {

        UsuarioModel _userModel = new UsuarioModel();

        List<Usuario> _listUsuario = _usuarioService.getUsuariosByIdGrupoSucursal(idgrupo, idsucursal);

        if (_listUsuario.isEmpty()) {

            _userModel.setSuccess(false);
            _userModel.setCode("400");
            _userModel.setMessage("No existen datos");

        } else {

            _userModel.setSuccess(true);
            _userModel.setCode("200");
            _userModel.setMessage("Se encontraron " + _listUsuario.size() + " Usuario(s)");
            _userModel.setData(_listUsuario);

        }

        return  _userModel;
    }

    @RequestMapping(value = "/hlp/show/sucursal/{idsucursal}", method = RequestMethod.GET)
    public UsuarioModel getUsuariosHLPByOficina(@PathVariable long idsucursal)
    {

        UsuarioModel _userModel = new UsuarioModel();

        List<Usuario> _listUsuario = _usuarioService.getUsuariosByIdOficina(idsucursal);

        if (_listUsuario.isEmpty()) {

            _userModel.setSuccess(false);
            _userModel.setCode("400");
            _userModel.setMessage("No existen datos");

        } else {

            _userModel.setSuccess(true);
            _userModel.setCode("200");
            _userModel.setMessage("Se encontraron " + _listUsuario.size() + " Usuario(s)");
            _userModel.setData(_listUsuario);

        }

        return  _userModel;
    }

    @RequestMapping(value = "/hlp/show/opcion/{idopcion}/", method = RequestMethod.GET)
    public UsuarioModel getUsuariosHLPByOpcion(@PathVariable long idopcion, @RequestParam("idgrupo") long idgrupo, @RequestParam("idoficina") long idoficina)
    {

        UsuarioModel _userModel = new UsuarioModel();

        List<Usuario> _listUsuario = _usuarioService.getUsuariosByIdOpcion(idopcion, idgrupo, idoficina);

        if (_listUsuario.isEmpty()) {

            _userModel.setSuccess(false);
            _userModel.setCode("400");
            _userModel.setMessage("No existen datos");

        } else {

            _userModel.setSuccess(true);
            _userModel.setCode("200");
            _userModel.setMessage("Se encontraron " + _listUsuario.size() + " Usuario(s)");
            _userModel.setData(_listUsuario);

        }

        return  _userModel;
    }

    @RequestMapping(value = "/hlp/show/grupo/{idgrupo}", method = RequestMethod.GET)
    public UsuarioModel getUsuariosHLPByGrupo(@PathVariable long idgrupo)
    {

        UsuarioModel _userModel = new UsuarioModel();

        List<Usuario> _listUsuario = _usuarioService.getUsuariosByIdGrupo(idgrupo);

        if (_listUsuario.isEmpty()) {

            _userModel.setSuccess(false);
            _userModel.setCode("400");
            _userModel.setMessage("No existen datos");

        } else {

            _userModel.setSuccess(true);
            _userModel.setCode("200");
            _userModel.setMessage("Se encontraron " + _listUsuario.size() + " Usuario(s)");
            _userModel.setData(_listUsuario);

        }

        return  _userModel;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public UsuarioModel logout(@RequestBody Usuario login) throws ServletException {
        UsuarioModel _userModel = new UsuarioModel();

        return _userModel;
    }

}
