/**
 */
package hu.bme.mit.magicdraw2gamma.trace.model.trace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.TracePackage
 * @generated
 */
public interface TraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TraceFactory eINSTANCE = hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>MD2G Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MD2G Trace</em>'.
	 * @generated
	 */
	MD2GTrace createMD2GTrace();

	/**
	 * Returns a new object of class '<em>Abstract Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Trace</em>'.
	 * @generated
	 */
	AbstractTrace createAbstractTrace();

	/**
	 * Returns a new object of class '<em>Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace</em>'.
	 * @generated
	 */
	Trace createTrace();

	/**
	 * Returns a new object of class '<em>Interface Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Trace</em>'.
	 * @generated
	 */
	InterfaceTrace createInterfaceTrace();

	/**
	 * Returns a new object of class '<em>Constraint Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint Trace</em>'.
	 * @generated
	 */
	ConstraintTrace createConstraintTrace();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TracePackage getTracePackage();

} //TraceFactory
