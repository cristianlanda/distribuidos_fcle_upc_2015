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
		
		String query="select trab.co_trab, trab.no_trab, trab.ap_pat_trab, trab.ap_mat_trab, trab.no_dire, trab.no_cups,"+ 
"trab.co_afps, trab.co_banc_abon,trab.fg_civi, trab.co_naci, trab.co_dpto, trab.co_prov,"+
"trab.co_prov, trab.co_dist, trab.fg_sexo, trab.fg_estado, trab.no_correo,  camp.desc_camp"+
" from tmtrab_empr trab, t_camp_post empr_camp, t_campana camp, t_empresa emp "+
"where "+
"empr_camp.co_camp=camp.co_camp "+
" and camp.co_emp=emp.co_emp "+
" and empr_camp.co_trab=trab.CO_TRAB"+
" and empr_camp.co_emp="+idEmpresa+
" and (trab.no_trab like '%'+"+nombres+"+'%' or trab.ap_pat_trab like '%'+"+nombres+"+'%' or trab.ap_mat_trab like '%'+"+nombres+"+'%')"+
" and empr_camp.Co_Camp like '%'+"+idCampanha+"+'%'"+
" and trab.co_trab like '%'+"+codigoTrabajador+"+'%' and trab.fg_estado=0 ";
		
		/*if(nombres.equals("") && codigoTrabajador.equals("") && idCampanha.equals("") ){
			query="select trab.co_trab, trab.no_trab, trab.ap_pat_trab, "
					+ "trab.ap_mat_trab, trab.no_dire, trab.no_cups, "
					+ "trab.co_afps, trab.co_banc_abon,trab.fg_civi, "
					+ "trab.co_naci, trab.co_dpto, trab.co_prov, "
					+ "trab.co_prov, trab.co_dist, trab.fg_sexo, "
					+ "trab.fg_estado, trab.no_correo  from tmtrab_empr trab, t_camp_post empr_camp, t_campana camp, t_empresa emp where empr_camp.co_camp=camp.co_camp and camp.co_emp=emp.co_emp and empr_camp.co_trab=trab.co_trab and emp.co_emp=? ";
		}else{
			
			//if(!idCampanha.equals("")){
				if(nombres.equals("") && !codigoTrabajador.equals("")){
					//query="select * from tmtrab_empr where co_trab like ? and ";
					
					query="select trab.co_trab, trab.no_trab, trab.ap_pat_trab, "
							+ "trab.ap_mat_trab, trab.no_dire, trab.no_cups, "
							+ "trab.co_afps, trab.co_banc_abon,trab.fg_civi, "
							+ "trab.co_naci, trab.co_dpto, trab.co_prov, "
							+ "trab.co_prov, trab.co_dist, trab.fg_sexo, "
							+ "trab.fg_estado, trab.no_correo  from tmtrab_empr trab, t_camp_post empr_camp, t_campana camp, t_empresa emp where co_trab like ?";
					
					if(!idCampanha.equals("")){
						query=query+" and camp.co_camp=empr_camp.co_camp and camp.co_camp=?";
					}
					
					System.out.println("query: "+query);
					
					filtro=codigoTrabajador;
				}
				if(!nombres.equals("") && codigoTrabajador.equals("")){
					//query="select * from tmtrab_empr where no_trab like ?";
					
					query="select trab.co_trab, trab.no_trab, trab.ap_pat_trab, "
							+ "trab.ap_mat_trab, trab.no_dire, trab.no_cups, "
							+ "trab.co_afps, trab.co_banc_abon,trab.fg_civi, "
							+ "trab.co_naci, trab.co_dpto, trab.co_prov, "
							+ "trab.co_prov, trab.co_dist, trab.fg_sexo, "
							+ "trab.fg_estado, trab.no_correo  from tmtrab_empr trab, t_camp_post empr_camp, t_campana camp, t_empresa emp where no_trab like ?";
					
					if(!idCampanha.equals("")){
						query=query+" and camp.co_camp=empr_camp.co_camp and camp.co_camp=?";
					}
					
					System.out.println("query: "+query);
					
					filtro=nombres;
				}*/
//			}else{
//				if(nombres.equals("") && !codigoTrabajador.equals("")){
//					query="select * from tmtrab_empr where co_trab like ?";
//					System.out.println("query: "+query);
//					filtro=codigoTrabajador;
//				}
//				if(!nombres.equals("") && codigoTrabajador.equals("")){
//					query="select * from tmtrab_empr where no_trab like ?";
//					System.out.println("query: "+query);
//					filtro=nombres;
//				}
//			}
		//}
		
		
		
        try {
        	con=ConexionDB.obtenerConexion();
    		
        	ps=con.prepareStatement(query);
//        	if(!filtro.equals("")){
//        		ps.setString(1, filtro+"%");
//        		
//        		if(!idCampanha.equals("")){
//        			ps.setInt(2, Integer.parseInt(idCampanha));
//        		}
//        		
//        	}else{
//        		ps.setInt(1, Integer.parseInt(idEmpresa));
//        	}
	        
        	System.out.println("query:"+query);
	        
	        rs=ps.executeQuery();
	        
	        while(rs.next()){
	        	Trabajador trabajador=new Trabajador(rs.getString("co_trab"), rs.getString("no_trab"), rs.getString("ap_pat_trab"), rs.getString("ap_mat_trab"),
	        			rs.getString("no_dire"), rs.getString("no_cups"), rs.getString("co_afps"), rs.getString("co_banc_abon"), rs.getString("fg_civi"),
	        			rs.getString("co_naci"), rs.getString("co_dpto"), rs.getString("co_prov"),
	        			rs.getString("co_dist"), rs.getString("fg_sexo"), rs.getString("fg_estado"), rs.getString("no_correo"), rs.getString("desc_camp"));
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
		List<Trabajador> list=new TrabajadorDaoImpl().obtenerTodos("", "","","1");
		
		
		for (Trabajador trabajador : list) {
			System.out.println(trabajador);
		}
		
		
		
		
	}


}
