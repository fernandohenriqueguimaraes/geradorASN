/*
 * package br.com.geradorASN.dao.impl;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.context.annotation.Primary; import
 * org.springframework.stereotype.Repository;
 * 
 * import br.com.geradorASN.dao.EmpresaDao; import
 * br.com.geradorASN.entity.Empresa;
 * 
 * @Repository(value = "EmpresaDao")
 * 
 * @Primary
 * 
 * @Qualifier("EmpresaDao") public class EmpresaDaoImpl implements EmpresaDao {
 * 
 * public EmpresaDaoImpl () {}
 * 
 * @Override public <S extends Empresa> S save(S entity) { return save(entity);
 * }
 * 
 * @Override public <S extends Empresa> Iterable<S> saveAll(Iterable<S>
 * entities) { return saveAll(entities); }
 * 
 * @Override public Optional<Empresa> findById(String id) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public boolean existsById(String id) { // TODO Auto-generated
 * method stub return false; }
 * 
 * @Override public Iterable<Empresa> findAll() { // TODO Auto-generated method
 * stub return null; }
 * 
 * @Override public Iterable<Empresa> findAllById(Iterable<String> ids) { //
 * TODO Auto-generated method stub return null; }
 * 
 * @Override public long count() { // TODO Auto-generated method stub return 0;
 * }
 * 
 * @Override public void deleteById(String id) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public void delete(Empresa entity) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public void deleteAll(Iterable<? extends Empresa> entities) { //
 * TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public void deleteAll() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public List<Empresa> getEmpresaByCnpj(String cnpj) { // TODO
 * Auto-generated method stub return null; }
 * 
 * }
 */