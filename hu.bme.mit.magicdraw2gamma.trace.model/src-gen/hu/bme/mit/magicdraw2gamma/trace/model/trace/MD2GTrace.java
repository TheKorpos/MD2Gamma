/**
 */
package hu.bme.mit.magicdraw2gamma.trace.model.trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MD2G Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace#getTraces <em>Traces</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.TracePackage#getMD2GTrace()
 * @model
 * @generated
 */
public interface MD2GTrace extends EObject {
	/**
	 * Returns the value of the '<em><b>Traces</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.magicdraw2gamma.trace.model.trace.AbstractTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' containment reference list.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.TracePackage#getMD2GTrace_Traces()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractTrace> getTraces();

} // MD2GTrace
