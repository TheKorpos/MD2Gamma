/**
 */
package hu.bme.mit.magicdraw2gamma.trace.model.trace;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.mit.bme.hu/magicdraw2gamma/trace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.MD2GTraceImpl <em>MD2G Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.MD2GTraceImpl
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl#getMD2GTrace()
	 * @generated
	 */
	int MD2G_TRACE = 0;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MD2G_TRACE__TRACES = 0;

	/**
	 * The number of structural features of the '<em>MD2G Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MD2G_TRACE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>MD2G Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MD2G_TRACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.AbstractTraceImpl <em>Abstract Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.AbstractTraceImpl
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl#getAbstractTrace()
	 * @generated
	 */
	int ABSTRACT_TRACE = 1;

	/**
	 * The number of structural features of the '<em>Abstract Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRACE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Abstract Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TraceImpl
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TARGET = ABSTRACT_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__SOURCE = ABSTRACT_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = ABSTRACT_TRACE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_OPERATION_COUNT = ABSTRACT_TRACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.InterfaceTraceImpl <em>Interface Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.InterfaceTraceImpl
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl#getInterfaceTrace()
	 * @generated
	 */
	int INTERFACE_TRACE = 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TRACE__TARGET = ABSTRACT_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TRACE__SOURCE = ABSTRACT_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interface Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TRACE_FEATURE_COUNT = ABSTRACT_TRACE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Interface Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TRACE_OPERATION_COUNT = ABSTRACT_TRACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.ConstraintTraceImpl <em>Constraint Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.ConstraintTraceImpl
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl#getConstraintTrace()
	 * @generated
	 */
	int CONSTRAINT_TRACE = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_TRACE__SOURCE = ABSTRACT_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_TRACE__TARGET = ABSTRACT_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constraint Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_TRACE_FEATURE_COUNT = ABSTRACT_TRACE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Constraint Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_TRACE_OPERATION_COUNT = ABSTRACT_TRACE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace <em>MD2G Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MD2G Trace</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace
	 * @generated
	 */
	EClass getMD2GTrace();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traces</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace#getTraces()
	 * @see #getMD2GTrace()
	 * @generated
	 */
	EReference getMD2GTrace_Traces();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.AbstractTrace <em>Abstract Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Trace</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.AbstractTrace
	 * @generated
	 */
	EClass getAbstractTrace();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace#getTarget()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Target();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace#getSource()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Source();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.InterfaceTrace <em>Interface Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Trace</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.InterfaceTrace
	 * @generated
	 */
	EClass getInterfaceTrace();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.InterfaceTrace#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.InterfaceTrace#getTarget()
	 * @see #getInterfaceTrace()
	 * @generated
	 */
	EReference getInterfaceTrace_Target();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.InterfaceTrace#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.InterfaceTrace#getSource()
	 * @see #getInterfaceTrace()
	 * @generated
	 */
	EReference getInterfaceTrace_Source();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.ConstraintTrace <em>Constraint Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Trace</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.ConstraintTrace
	 * @generated
	 */
	EClass getConstraintTrace();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.ConstraintTrace#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.ConstraintTrace#getSource()
	 * @see #getConstraintTrace()
	 * @generated
	 */
	EReference getConstraintTrace_Source();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.ConstraintTrace#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.ConstraintTrace#getTarget()
	 * @see #getConstraintTrace()
	 * @generated
	 */
	EReference getConstraintTrace_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.MD2GTraceImpl <em>MD2G Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.MD2GTraceImpl
		 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl#getMD2GTrace()
		 * @generated
		 */
		EClass MD2G_TRACE = eINSTANCE.getMD2GTrace();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MD2G_TRACE__TRACES = eINSTANCE.getMD2GTrace_Traces();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.AbstractTraceImpl <em>Abstract Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.AbstractTraceImpl
		 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl#getAbstractTrace()
		 * @generated
		 */
		EClass ABSTRACT_TRACE = eINSTANCE.getAbstractTrace();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TraceImpl
		 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TARGET = eINSTANCE.getTrace_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__SOURCE = eINSTANCE.getTrace_Source();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.InterfaceTraceImpl <em>Interface Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.InterfaceTraceImpl
		 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl#getInterfaceTrace()
		 * @generated
		 */
		EClass INTERFACE_TRACE = eINSTANCE.getInterfaceTrace();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TRACE__TARGET = eINSTANCE.getInterfaceTrace_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TRACE__SOURCE = eINSTANCE.getInterfaceTrace_Source();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.ConstraintTraceImpl <em>Constraint Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.ConstraintTraceImpl
		 * @see hu.bme.mit.magicdraw2gamma.trace.model.trace.impl.TracePackageImpl#getConstraintTrace()
		 * @generated
		 */
		EClass CONSTRAINT_TRACE = eINSTANCE.getConstraintTrace();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_TRACE__SOURCE = eINSTANCE.getConstraintTrace_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_TRACE__TARGET = eINSTANCE.getConstraintTrace_Target();

	}

} //TracePackage
