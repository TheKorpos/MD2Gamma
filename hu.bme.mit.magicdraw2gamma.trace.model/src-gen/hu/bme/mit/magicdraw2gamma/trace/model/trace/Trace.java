/**
 */
package hu.bme.mit.magicdraw2gamma.trace.model.trace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace#getTarget <em>Target</em>}</li>
 *   <li>{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.TracePackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends AbstractTrace {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.TracePackage#getTrace_Target()
	 * @model
	 * @generated
	 */
	EList<EObject> getTarget();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference list.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.TracePackage#getTrace_Source()
	 * @model
	 * @generated
	 */
	EList<EObject> getSource();

} // Trace
