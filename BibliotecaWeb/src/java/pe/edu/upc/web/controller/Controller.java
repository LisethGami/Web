package pe.edu.upc.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pe.edu.upc.core.dao.AutorDao;
import pe.edu.upc.core.dao.CategoriaDao;
import pe.edu.upc.core.dao.EditorialDao;
import pe.edu.upc.core.dao.LibroDao;
import pe.edu.upc.core.dao.ReservaDao;
import pe.edu.upc.core.dao.TipousuarioDao;
import pe.edu.upc.core.dao.UsuarioDao;
import pe.edu.upc.core.entity.Autor;
import pe.edu.upc.core.entity.Categoria;
import pe.edu.upc.core.entity.Editorial;
import pe.edu.upc.core.entity.Libro;
import pe.edu.upc.core.entity.Reserva;
import pe.edu.upc.core.entity.Tipousuario;
import pe.edu.upc.core.entity.Usuario;

@ManagedBean
@SessionScoped
public class Controller {
    
    //DAO
    private CategoriaDao categoriaDao = new CategoriaDao();
    private AutorDao autorDao = new AutorDao();
    private EditorialDao editorialDao = new EditorialDao();
    private TipousuarioDao tipousuarioDao = new TipousuarioDao();
    private LibroDao libroDao = new LibroDao();
    private ReservaDao reservaDao = new ReservaDao();
    private UsuarioDao usuarioDao = new UsuarioDao();
    
    //Variables para almacenar información
    private List<Categoria> listaCategorias = new ArrayList<>();
    private List<Autor> listaAutores = new ArrayList<>();
    private List<Editorial> listaEdioriales = new ArrayList<>();
    private List<Tipousuario> listaTipousuarios = new ArrayList<>();
    private List<Libro> listLibros = new ArrayList<>();
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private int idTipousuarioSeleccionado;
    private int idAutorSeleccionado;
    private int idCategoriaSeleccionada;
    private int idEditorialSeleccionada;
    private int idLibroSeleccionado;
    private String idUsuarioSeleccionado;
    
    //Mantenimiento
    private Categoria categoria = new Categoria();
    private Autor autor = new Autor();
    private Editorial editorial = new Editorial();
    private Tipousuario tipousuario = new Tipousuario();
    private Libro libro = new Libro();
    private Reserva reserva = new Reserva();
    private Usuario usuario = new Usuario();
    
    //***********
    //METODOS
    //***********
    public void inicializar(){
       this.limpiar();
    }
    
    //Categoria
    public String guardarCategoria(){
        try{
            this.categoriaDao.guardar(this.categoria);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarCategorias";
    }
    
    public String editarCategoria(Integer idCategoria){
        try{
            this.categoria = this.categoriaDao.obtener(idCategoria);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarCategorias";
    }
    
    public void eliminarCategoria(Integer idCategoria){
        try{
            this.categoriaDao.eliminar(idCategoria);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String irRegistrarCategoria(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarCategorias";
    }
    
    public String irListarCategoria(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarCategorias";
    }
    
    
    //Autor
    public String guardarAutor(){
        try{
            this.autorDao.guardar(this.autor);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarAutores";
    }
    
    public String editarAutor(Integer idAutor){
        try{
            this.autor = this.autorDao.obtener(idAutor);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarAutores";
    }
    
    public void eliminarAutor(Integer idCategoria){
        try{
            this.categoriaDao.eliminar(idCategoria);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String irRegistrarAutor(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarAutores";
    }
    
    public String irListarAutor(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarAutores";
    }
    
    
    //Editorial
    public String guardarEditorial(){
        try{
            this.editorialDao.guardar(this.editorial);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarEditoriales";
    }
    
    public String editarEditorial(Integer idEditorial){
        try{
            this.editorial = this.editorialDao.obtener(idEditorial);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarEditoriales";
    }
    
    public void eliminarEditorial(Integer idEditorial){
        try{
            this.editorialDao.eliminar(idEditorial);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String irRegistrarEditorial(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarEditoriales";
    }
    
    public String irListarEditorial(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarEditoriales";
    }
    
    
    //Tipo de Usuario

    
    
    //Usuario
    public String guardarUsuario(){
        try{
            this.usuario.setTIPOUSUARIOidTipoUsuario(this.tipousuarioDao.obtener(idTipousuarioSeleccionado));
            this.usuarioDao.guardar(this.usuario);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarUsuarios";
    }
    
    public String editarUsuario(String idUsuario){
        try{
            this.usuario = this.usuarioDao.obtener(idUsuario);
            this.idTipousuarioSeleccionado
                    = this.usuario.getTIPOUSUARIOidTipoUsuario().getIdTipoUsuario();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarUsuarios";
    }
    
    public void eliminarUsuario(String idUsuario){
        try{
            this.usuarioDao.eliminar(idUsuario);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String irRegistrarUsuario(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarUsuarios";
    }
    
    public String irListarUsuario(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarUsuarios";
    }
    
    
    //Reserva
    public String guardarReserva(){
        try{
            this.reserva.setLIBROidLibro(this.libroDao.obtener(idLibroSeleccionado));
            this.reserva.setUSUARIOcodUsuario(this.usuarioDao.obtener(idUsuarioSeleccionado));
            this.reservaDao.guardar(this.reserva);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarReservas";
    }
    
    public String editarReserva(Integer idReserva){
        try{
            this.reserva = this.reservaDao.obtener(idReserva);
            this.idLibroSeleccionado = this.reserva.getLIBROidLibro().getIdLibro();
            this.idUsuarioSeleccionado = this.reserva.getUSUARIOcodUsuario().getCodUsuario();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarReservas";
    }
    
    public void eliminarReserva(Integer idReserva){
        try{
            this.reservaDao.eliminar(idReserva);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String irRegistrarReserva(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarReservas";
    }
    
    public String irListarReserva(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarReservas";
    }
    
    

    //Libro
    public String guardarLibro(){
        try{
            this.libro.setAUTORidAutor(this.autorDao.obtener(idAutorSeleccionado));
            this.libro.setCATEGORIAidCategoria(this.categoriaDao.obtener(idCategoriaSeleccionada));
            this.libro.setEDITORIALidEditorial(this.editorialDao.obtener(idEditorialSeleccionada));
            this.libroDao.guardar(this.libro);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarLibros";
    }
    
    public String editarLibro(Integer idLibro){
        try{
            this.libro = this.libroDao.obtener(idLibro);
            this.idAutorSeleccionado = this.libro.getAUTORidAutor().getIdAutor();
            this.idCategoriaSeleccionada = this.libro.getCATEGORIAidCategoria().getIdCategoria();
            this.idEditorialSeleccionada = this.libro.getEDITORIALidEditorial().getIdEditorial();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarLibros";
    }
    
    public void eliminarLibro(Integer idLibro){
        try{
            this.autorDao.eliminar(idLibro);
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String irRegistrarLibro(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "registrarLibros";
    }
    
    public String irListarLibro(){
        try{
            this.limpiar();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "listarLibros";
    }
    
    
    private void limpiar(){
        try{
            
            this.autor = new Autor();
            this.categoria = new Categoria();
            this.editorial = new Editorial();
            
            this.listaAutores = this.autorDao.listar();
            this.listaCategorias = this.categoriaDao.listar();
            this.listaEdioriales = this.editorialDao.listar();
        
            this.idTipousuarioSeleccionado = 1;
            this.idAutorSeleccionado = 1;
            this.idCategoriaSeleccionada = 1;
            this.idEditorialSeleccionada  = 1;
            this.idLibroSeleccionado = 1;
            this.idUsuarioSeleccionado = "";
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //***********
    //GET & SET
    //***********

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(List<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public List<Editorial> getListaEdioriales() {
        return listaEdioriales;
    }

    public void setListaEdioriales(List<Editorial> listaEdioriales) {
        this.listaEdioriales = listaEdioriales;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public List<Tipousuario> getListaTipousuarios() {
        return listaTipousuarios;
    }

    public void setListaTipousuarios(List<Tipousuario> listaTipousuarios) {
        this.listaTipousuarios = listaTipousuarios;
    }

    public List<Libro> getListLibros() {
        return listLibros;
    }

    public void setListLibros(List<Libro> listLibros) {
        this.listLibros = listLibros;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Tipousuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(Tipousuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdTipousuarioSeleccionado() {
        return idTipousuarioSeleccionado;
    }

    public void setIdTipousuarioSeleccionado(int idTipousuarioSeleccionado) {
        this.idTipousuarioSeleccionado = idTipousuarioSeleccionado;
    }

    public int getIdAutorSeleccionado() {
        return idAutorSeleccionado;
    }

    public void setIdAutorSeleccionado(int idAutorSeleccionado) {
        this.idAutorSeleccionado = idAutorSeleccionado;
    }

    public int getIdCategoriaSeleccionada() {
        return idCategoriaSeleccionada;
    }

    public void setIdCategoriaSeleccionada(int idCategoriaSeleccionada) {
        this.idCategoriaSeleccionada = idCategoriaSeleccionada;
    }

    public int getIdEditorialSeleccionada() {
        return idEditorialSeleccionada;
    }

    public void setIdEditorialSeleccionada(int idEditorialSeleccionada) {
        this.idEditorialSeleccionada = idEditorialSeleccionada;
    }

    public int getIdLibroSeleccionado() {
        return idLibroSeleccionado;
    }

    public void setIdLibroSeleccionado(int idLibroSeleccionado) {
        this.idLibroSeleccionado = idLibroSeleccionado;
    }

    public String getIdUsuarioSeleccionado() {
        return idUsuarioSeleccionado;
    }

    public void setIdUsuarioSeleccionado(String idUsuarioSeleccionado) {
        this.idUsuarioSeleccionado = idUsuarioSeleccionado;
    }
    
    
    
    
}
