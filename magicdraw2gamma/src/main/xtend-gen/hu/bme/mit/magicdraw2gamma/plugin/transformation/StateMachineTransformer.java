package hu.bme.mit.magicdraw2gamma.plugin.transformation;

import com.google.common.collect.Iterables;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import hu.bme.mit.gamma.statechart.model.Component;
import hu.bme.mit.gamma.statechart.model.InterfaceRealization;
import hu.bme.mit.gamma.statechart.model.Port;
import hu.bme.mit.gamma.statechart.model.RealizationMode;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.interface_.Interface;
import hu.bme.mit.gamma.statechart.model.interface_.InterfaceFactory;
import hu.bme.mit.gamma.statechart.model.interface_.InterfacePackage;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer;
import hu.bme.mit.magicdraw2gamma.plugin.transformation.batch.MagicdrawToGammaTransformer;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.AbstractTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.InterfaceTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StateMachineTransformer {
  private String packageName(final StateMachine c) {
    return c.getQualifiedName().substring(0, c.getQualifiedName().lastIndexOf("::")).replace("::", ".").toLowerCase();
  }
  
  private String toFilePath(final String s) {
    return s.replace(".", File.separator);
  }
  
  public Set<hu.bme.mit.gamma.statechart.model.Package> transform(final Collection<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> statechartDefinitions, final ResourceSet resourceSet) {
    final Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> mdSet = IterableExtensions.<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>toSet(statechartDefinitions);
    final MD2GTrace traceRoot = TraceFactory.eINSTANCE.createMD2GTrace();
    final HashSet<hu.bme.mit.gamma.statechart.model.Package> gSet = new HashSet<hu.bme.mit.gamma.statechart.model.Package>();
    final Function1<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class, Boolean> _function = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class it) -> {
      Behavior _classifierBehavior = it.getClassifierBehavior();
      return Boolean.valueOf((_classifierBehavior instanceof StateMachine));
    };
    final Consumer<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> _function_1 = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class it) -> {
      final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class mdBlock = it;
      Behavior _classifierBehavior = it.getClassifierBehavior();
      final StateMachine stmt = ((StateMachine) _classifierBehavior);
      Interface _createInterface = InterfaceFactory.eINSTANCE.createInterface();
      final Procedure1<Interface> _function_2 = (Interface it_1) -> {
        String _name = stmt.getName();
        String _plus = (_name + "_ClassInterface");
        it_1.setName(_plus);
      };
      final Interface gInterface = ObjectExtensions.<Interface>operator_doubleArrow(_createInterface, _function_2);
      StatechartDefinition _createStatechartDefinition = StatechartModelFactory.eINSTANCE.createStatechartDefinition();
      final Procedure1<StatechartDefinition> _function_3 = (StatechartDefinition it_1) -> {
        it_1.setName(stmt.getName());
        EList<Port> _ports = it_1.getPorts();
        Port _createPort = StatechartModelFactory.eINSTANCE.createPort();
        final Procedure1<Port> _function_4 = (Port it_2) -> {
          String _name = stmt.getName();
          String _plus = (_name + "_ClassPort");
          it_2.setName(_plus);
          InterfaceRealization _createInterfaceRealization = StatechartModelFactory.eINSTANCE.createInterfaceRealization();
          final Procedure1<InterfaceRealization> _function_5 = (InterfaceRealization it_3) -> {
            it_3.setRealizationMode(RealizationMode.PROVIDED);
            it_3.setInterface(gInterface);
          };
          InterfaceRealization _doubleArrow = ObjectExtensions.<InterfaceRealization>operator_doubleArrow(_createInterfaceRealization, _function_5);
          it_2.setInterfaceRealization(_doubleArrow);
        };
        Port _doubleArrow = ObjectExtensions.<Port>operator_doubleArrow(_createPort, _function_4);
        _ports.add(_doubleArrow);
      };
      final StatechartDefinition gStatechart = ObjectExtensions.<StatechartDefinition>operator_doubleArrow(_createStatechartDefinition, _function_3);
      InterfaceTrace _createInterfaceTrace = TraceFactory.eINSTANCE.createInterfaceTrace();
      final Procedure1<InterfaceTrace> _function_4 = (InterfaceTrace it_1) -> {
        EList<EObject> _source = it_1.getSource();
        _source.add(mdBlock);
        EList<EObject> _target = it_1.getTarget();
        _target.add(gInterface);
      };
      final InterfaceTrace operationsInterfaceTrace = ObjectExtensions.<InterfaceTrace>operator_doubleArrow(_createInterfaceTrace, _function_4);
      Trace _createTrace = TraceFactory.eINSTANCE.createTrace();
      final Procedure1<Trace> _function_5 = (Trace it_1) -> {
        EList<EObject> _source = it_1.getSource();
        _source.add(stmt);
        EList<EObject> _target = it_1.getTarget();
        _target.add(gStatechart);
      };
      final Trace trace = ObjectExtensions.<Trace>operator_doubleArrow(_createTrace, _function_5);
      hu.bme.mit.gamma.statechart.model.Package _createPackage = StatechartModelFactory.eINSTANCE.createPackage();
      final Procedure1<hu.bme.mit.gamma.statechart.model.Package> _function_6 = (hu.bme.mit.gamma.statechart.model.Package it_1) -> {
        it_1.setName(this.packageName(stmt));
        EList<Component> _components = it_1.getComponents();
        _components.add(gStatechart);
        EList<Interface> _interfaces = it_1.getInterfaces();
        _interfaces.add(gInterface);
      };
      final hu.bme.mit.gamma.statechart.model.Package gPackage = ObjectExtensions.<hu.bme.mit.gamma.statechart.model.Package>operator_doubleArrow(_createPackage, _function_6);
      EList<AbstractTrace> _traces = traceRoot.getTraces();
      Iterables.<AbstractTrace>addAll(_traces, Collections.<AbstractTrace>unmodifiableList(CollectionLiterals.<AbstractTrace>newArrayList(trace, operationsInterfaceTrace)));
      gSet.add(gPackage);
    };
    IterableExtensions.<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>filter(statechartDefinitions, _function).forEach(_function_1);
    final HashSet<EObject> all = new HashSet<EObject>();
    Iterables.<EObject>addAll(all, mdSet);
    Iterables.<EObject>addAll(all, gSet);
    all.add(traceRoot);
    final BaseIndexOptions options = new BaseIndexOptions();
    final EMFScope scope = new EMFScope(all, options);
    InterfacePackage.eINSTANCE.getNsURI();
    final ViatraQueryEngine engine = ViatraQueryEngine.on(scope);
    final Tracer tracer = new Tracer(traceRoot, engine);
    final MagicdrawToGammaTransformer tra = new MagicdrawToGammaTransformer(engine, tracer);
    tra.execute();
    return gSet;
  }
}
