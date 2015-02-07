package com.rrhhintegration.servicesweb.persistence.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rrhhintegration.servicesweb.bean.Trabajador;
import com.rrhhintegration.servicesweb.persistence.conn.ConexionDB;
import com.rrhhintegration.servicesweb.persistence.dao.TrabajadorDao;
import com.rrhhintegration.servicesweb.utils.Utils;

public class TrabajadorDaoImpl implements TrabajadorDao {

	@Override
	public String actualizarTrabajador(Trabajador trabajador){
		
		Connection con=null;
		PreparedStatement ps=null;		
		
		if(trabajador==null){
			return "0001";
		}
		
		if(trabajador.getCodigoDNI()==null){
			return "0001";
		}
		
		String query="update tmtrab_empr set no_trab=?, ap_pat_trab=?,ap_mat_trab=?,no_dire=?,"
				+ "no_cups=?,co_afps=?,co_banc_abon=?,fg_civi=?,co_naci=?,co_dpto=?,co_prov=?,"
				+ "co_dist=?,fg_sexo=?,fg_estado=?,no_correo=? where co_trab=?";
		
        try {
        	con=ConexionDB.obtenerConexion();
    		
        	ps=con.prepareStatement(query);
        	
	        ps.setString(1, trabajador.getNombres());
	        ps.setString(2, trabajador.getApePat());
	        ps.setString(3, trabajador.getApeMat());
	        ps.setString(4, trabajador.getDireccion());
	        ps.setString(5, trabajador.getNumCUPS());
	        ps.setString(6, trabajador.getCodigoAFP());
	        ps.setString(7, trabajador.getCodigoBancoAbono());
	        ps.setString(8, trabajador.getEstadoCivil());
	        ps.setString(9, trabajador.getCodigoNacionalidad());
	        ps.setString(10, trabajador.getCodigoDepartamento());
	        ps.setString(11, trabajador.getCodigoProvincia());
	        ps.setString(12, trabajador.getCodigoDistrito());
	        ps.setString(13, trabajador.getSexoColaborador());
	        ps.setString(14, trabajador.getEstadoActivo());
	        ps.setString(15, trabajador.getCorreo());
	        ps.setString(16, trabajador.getCodigoDNI());
	        
	        ps.executeUpdate();
	        
	        return "0000";
        
        } catch (SQLException e) {
        	System.out.println("Error al obtener conexión de Base de Datos o actualizar Trabajador. "+e.toString());
        } catch (Exception e) {
        	System.out.println("Error general en actualizar Trabajador. "+e.toString());
		} finally{
			try {
				if(ps!=null){					
					ps.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion PreparedStatement. "+e.toString());
			}
			try {
				if(con!=null){					
					con.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion Connection. "+e.toString());
			}
		}
		
		
		
		
		/*if(trabajador==null){
			return "0001";
		}
		
		if(trabajador.getCodigoDNI()==null){
			return "0001";
		}
		
		for(int i=0;i<PersistObjectUtil.listTrabajadores.size();i++){
			if(PersistObjectUtil.listTrabajadores.get(i).getCodigoDNI().equals(trabajador.getCodigoDNI().trim())){
				PersistObjectUtil.listTrabajadores.set(i, trabajador);
				return "0000";
			}
		}*/
		
		return "0001";
	}

		
	
		
	@Override
	public String eliminarTrabajador(String codigoTrabajador) {
		
		Connection con=null;
		PreparedStatement ps=null;		
		
		if(codigoTrabajador==null){
			return "0001";
		}
		
		/*for(int i=0;i<PersistObjectUtil.listTrabajadores.size();i++){
			if(PersistObjectUtil.listTrabajadores.get(i).getCodigoDNI().equals(codigoTrabajador.trim())){
				PersistObjectUtil.listTrabajadores.remove(i);
				return "0000";
			}
		}*/
		
		String query="delete tmtrab_empr where co_trab=?";
		
        try {
        	con=ConexionDB.obtenerConexion();
    		
        	ps=con.prepareStatement(query);
        	
	        ps.setString(1, codigoTrabajador);
	        
	        ps.executeUpdate();
	        
	        return "0000";
        
        } catch (SQLException e) {
        	System.out.println("Error al obtener conexión de Base de Datos o eliminar Trabajador. "+e.toString());
        } catch (Exception e) {
        	System.out.println("Error general en eliminar Trabajador. "+e.toString());
		} finally{
			try {
				if(ps!=null){					
					ps.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion PreparedStatement. "+e.toString());
			}
			try {
				if(con!=null){					
					con.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion Connection. "+e.toString());
			}
		}
		
		
		
		return "0001";
	}

	@Override
	public Trabajador obtenerUno(String codigoTrabajador) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Trabajador trabajador=new Trabajador();
		if(codigoTrabajador==null){
			return trabajador;
		}
		/*for(int i=0;i<PersistObjectUtil.listTrabajadores.size();i++){
			if(PersistObjectUtil.listTrabajadores.get(i).getCodigoDNI().equals(codigoTrabajador.trim())){
				
				return PersistObjectUtil.listTrabajadores.get(i);
			}
		}*/
			
		
		String query="select * from tmtrab_empr where co_trab=?";
		
        try {
        	con=ConexionDB.obtenerConexion();
        	ps=con.prepareStatement(query);
        	
	        ps.setString(1, codigoTrabajador);
	        
	        rs=ps.executeQuery();
	        
	        if(rs.next()){
	        	trabajador=new Trabajador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
	        			rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
	        			rs.getString(10), rs.getString(11), rs.getString(12),
	        			rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16));
	        }	        
	        
        }  catch (SQLException e) {
        	System.out.println("Error en obtener un Trabajador. "+e.toString());
        }  catch (Exception e) {
        	System.out.println("Error general en obtener un Trabajador. "+e.toString());
		} finally{
			try {
				if(ps!=null){					
					ps.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion PreparedStatement. "+e.toString());
			}
			try {
				if(con!=null){					
					con.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion Connection. "+e.toString());
			}
		}
        
		return trabajador;
	}

	@Override
	public List<Trabajador> obtenerTodos(String nombres,
			String codigoTrabajador) {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String filtro="";
		List<Trabajador> filtroList=new ArrayList<Trabajador>();
		
		nombres=Utils.validateNull(nombres);
		codigoTrabajador=Utils.validateNull(codigoTrabajador);
		
		/*if((nombres==null ||"".equals(nombres.trim()))  && (codigoTrabajador==null ||"".equals(codigoTrabajador.trim())) ){
			return PersistObjectUtil.listTrabajadores;
		}
		for(int i=0;i<PersistObjectUtil.listTrabajadores.size();i++){
			if(PersistObjectUtil.listTrabajadores.get(i).getCodigoDNI().equals(codigoTrabajador)){
				filtroList.add(PersistObjectUtil.listTrabajadores.get(i));
				
			}	
		}*/
		
		System.out.println("nombres:"+nombres+", codigotrabajador="+codigoTrabajador);
		
		String query="";
		
		if(nombres.equals("") && codigoTrabajador.equals("") ){
			query="select * from tmtrab_empr";
		}else{
			if(nombres.equals("") && !codigoTrabajador.equals("")){
				query="select * from tmtrab_empr where co_trab like ?";
				filtro=codigoTrabajador;
			}
			if(!nombres.equals("") && codigoTrabajador.equals("")){
				query="select * from tmtrab_empr where no_trab like ?";
				filtro=nombres;
			}
		}
		
		
		
        try {
        	con=ConexionDB.obtenerConexion();
    		
        	ps=con.prepareStatement(query);
        	if(!filtro.equals("")){
        		ps.setString(1, filtro+"%");
        	}
	        
        	System.out.println("query:"+query);
	        
	        rs=ps.executeQuery();
	        
	        while(rs.next()){
	        	Trabajador trabajador=new Trabajador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
	        			rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
	        			rs.getString(10), rs.getString(11), rs.getString(12),
	        			rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16));
	        	filtroList.add(trabajador);
	        }	        
	        
        } catch (SQLException e) {
        	System.out.println("Error al obtener conexión de Base de Datos o buscar Trabajador. "+e.toString());
        } catch (Exception e) {
        	System.out.println("Error general en buscar Trabajador. "+e.toString());
		} finally{
			try {
				if(ps!=null){					
					ps.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion PreparedStatement. "+e.toString());
			}
			try {
				if(con!=null){					
					con.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion Connection. "+e.toString());
			}
		}	
		
		return filtroList;
	}
	
	@Override
	public List<Trabajador> obtenerTodos(String nombres,
			String codigoTrabajador, String idCampanha, String idEmpresa) {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String filtro="";
		List<Trabajador> filtroList=new ArrayList<Trabajador>();
		
		nombres=Utils.validateNull(nombres);
		codigoTrabajador=Utils.validateNull(codigoTrabajador);
		idCampanha=Utils.validateNull(idCampanha);
		
		System.out.println("nombres:"+nombres+", codigotrabajador="+codigoTrabajador);
		
		String query="";
		
		if(nombres.equals("") && codigoTrabajador.equals("") && idCampanha.equals("") ){
			query="select * from tmtrab_empr where ";
		}else{
			if(nombres.equals("") && !codigoTrabajador.equals("")){
				query="select * from tmtrab_empr where co_trab like ?";
				filtro=codigoTrabajador;
			}
			if(!nombres.equals("") && codigoTrabajador.equals("")){
				query="select * from tmtrab_empr where no_trab like ?";
				filtro=nombres;
			}
		}
		
		
		
        try {
        	con=ConexionDB.obtenerConexion();
    		
        	ps=con.prepareStatement(query);
        	if(!filtro.equals("")){
        		ps.setString(1, filtro+"%");
        	}
	        
        	System.out.println("query:"+query);
	        
	        rs=ps.executeQuery();
	        
	        while(rs.next()){
	        	Trabajador trabajador=new Trabajador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
	        			rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
	        			rs.getString(10), rs.getString(11), rs.getString(12),
	        			rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16));
	        	filtroList.add(trabajador);
	        }	        
	        
        } catch (SQLException e) {
        	System.out.println("Error al obtener conexión de Base de Datos o buscar Trabajador. "+e.toString());
        } catch (Exception e) {
        	System.out.println("Error general en buscar Trabajador. "+e.toString());
		} finally{
			try {
				if(ps!=null){					
					ps.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion PreparedStatement. "+e.toString());
			}
			try {
				if(con!=null){					
					con.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion Connection. "+e.toString());
			}
		}	
		
		return filtroList;
	}

	@Override
	public String registrarTrabajador(Trabajador trabajador) {
		/*PersistObjectUtil.listTrabajadores.add(trabajador);
		return "0000";*/
		Connection con=null;
		PreparedStatement ps=null;		
		
		if(trabajador==null){
			return "0001";
		}
		
		if(trabajador.getCodigoDNI()==null){
			return "0001";
		}
		
		String query="insert into tmtrab_empr values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
        try {
        	con=ConexionDB.obtenerConexion();
    		
        	ps=con.prepareStatement(query);
        	
        	ps.setString(1, trabajador.getCodigoDNI());
	        ps.setString(2, trabajador.getNombres());
	        ps.setString(3, trabajador.getApePat());
	        ps.setString(4, trabajador.getApeMat());
	        ps.setString(5, trabajador.getDireccion());
	        ps.setString(6, trabajador.getNumCUPS());
	        ps.setString(7, trabajador.getCodigoAFP());
	        ps.setString(8, trabajador.getCodigoBancoAbono());
	        ps.setString(9, trabajador.getEstadoCivil());
	        ps.setString(10, trabajador.getCodigoNacionalidad());
	        ps.setString(11, trabajador.getCodigoDepartamento());
	        ps.setString(12, trabajador.getCodigoProvincia());
	        ps.setString(13, trabajador.getCodigoDistrito());
	        ps.setString(14, trabajador.getSexoColaborador());
	        ps.setString(15, trabajador.getEstadoActivo());
	        ps.setString(16, trabajador.getCorreo());
	        
	        
	        ps.executeUpdate();
	        
	        return "0000";
        
        } catch (SQLException e) {
        	System.out.println("Error al obtener conexión de Base de Datos o resgistrar Trabajador. "+e.toString());
        } catch (Exception e) {
        	System.out.println("Error general en registrar Trabajador. "+e.toString());
		} finally{
			try {
				if(ps!=null){					
					ps.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion PreparedStatement. "+e.toString());
			}
			try {
				if(con!=null){					
					con.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion Connection. "+e.toString());
			}
		}
		
		
		
		
		
		
		return "0001";
	}
	


	@Override
	public String actualizarEstadoTrabajador(Trabajador trabajador) {
		Connection con=null;
		PreparedStatement ps=null;		
		
		if(trabajador==null){
			return "0001";
		}
		
		if(trabajador.getCodigoDNI()==null){
			return "0001";
		}
		
		String query="update tmtrab_empr set fg_estado=? where co_trab=?";
		
        try {
        	con=ConexionDB.obtenerConexion();
    		
        	ps=con.prepareStatement(query);
        	
	        ps.setString(1, trabajador.getEstadoActivo());
	        ps.setString(2, trabajador.getCodigoDNI());
	        
	        ps.executeUpdate();
	        
	        return "0000";
        
        } catch (SQLException e) {
        	System.out.println("Error al obtener conexión de Base de Datos o actualizar estado Trabajador. "+e.toString());
        } catch (Exception e) {
        	System.out.println("Error general en actualizar estado Trabajador. "+e.toString());
		} finally{
			try {
				if(ps!=null){					
					ps.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion PreparedStatement. "+e.toString());
			}
			try {
				if(con!=null){					
					con.close();					
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion Connection. "+e.toString());
			}
		}
		
		
		
		return "0001";
	}
	
	
	public static void main(String[] args) {
		List<Trabajador> list=new TrabajadorDaoImpl().obtenerTodos("", "");
		
		
		for (Trabajador trabajador : list) {
			System.out.println(trabajador);
		}
		
		
		
		
	}


}
