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
import hu.bme.mit.magicdraw2gamma.plugin.transformation.NameFormatter;
import hu.bme.mit.magicdraw2gamma.plugin.transformation.batch.MagicdrawToGammaTransformer;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.AbstractTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.InterfaceTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StateMachineTransformer {
  @Extension
  private NameFormatter formatter = new NameFormatter();
  
  private final Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> mdSet;
  
  private final MD2GTrace traceRoot = TraceFactory.eINSTANCE.createMD2GTrace();
  
  private final HashSet<hu.bme.mit.gamma.statechart.model.Package> gSet = new HashSet<hu.bme.mit.gamma.statechart.model.Package>();
  
  private final ResourceSet resourceSet;
  
  public StateMachineTransformer(final Collection<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> statechartDefinitions, final ResourceSet resourceSet) {
    this.resourceSet = resourceSet;
    this.mdSet = IterableExtensions.<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>toSet(statechartDefinitions);
  }
  
  public Map<String, AbstractCollection<?>> transform() {
    final Function1<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class, Boolean> _function = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class it) -> {
      return Boolean.valueOf((it instanceof StateMachine));
    };
    final Consumer<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> _function_1 = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class it) -> {
      final StateMachine mdStatemachine = ((StateMachine) it);
      StatechartDefinition _createStatechartDefinition = StatechartModelFactory.eINSTANCE.createStatechartDefinition();
      final Procedure1<StatechartDefinition> _function_2 = (StatechartDefinition it_1) -> {
        it_1.setName(this.formatter.fomratName(mdStatemachine.getName()));
      };
      final StatechartDefinition gStatechart = ObjectExtensions.<StatechartDefinition>operator_doubleArrow(_createStatechartDefinition, _function_2);
      hu.bme.mit.gamma.statechart.model.Package _createPackage = StatechartModelFactory.eINSTANCE.createPackage();
      final Procedure1<hu.bme.mit.gamma.statechart.model.Package> _function_3 = (hu.bme.mit.gamma.statechart.model.Package it_1) -> {
        it_1.setName(this.formatter.fomratName(mdStatemachine.getName().toLowerCase()));
        EList<Component> _components = it_1.getComponents();
        _components.add(gStatechart);
      };
      final hu.bme.mit.gamma.statechart.model.Package gPackage = ObjectExtensions.<hu.bme.mit.gamma.statechart.model.Package>operator_doubleArrow(_createPackage, _function_3);
      this.gSet.add(gPackage);
      this.prepareStateMachine(mdStatemachine, gPackage, gStatechart);
    };
    IterableExtensions.<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>filter(this.mdSet, _function).forEach(_function_1);
    final Function1<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class, Boolean> _function_2 = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class it) -> {
      Behavior _classifierBehavior = it.getClassifierBehavior();
      return Boolean.valueOf((_classifierBehavior instanceof StateMachine));
    };
    final Consumer<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> _function_3 = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class it) -> {
      final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class mdBlock = it;
      Behavior _classifierBehavior = it.getClassifierBehavior();
      final StateMachine stmt = ((StateMachine) _classifierBehavior);
      Interface _createInterface = InterfaceFactory.eINSTANCE.createInterface();
      final Procedure1<Interface> _function_4 = (Interface it_1) -> {
        String _fomratName = this.formatter.fomratName(mdBlock.getName());
        String _plus = ("Block_Interface_For" + _fomratName);
        it_1.setName(_plus);
      };
      final Interface gInterface = ObjectExtensions.<Interface>operator_doubleArrow(_createInterface, _function_4);
      StatechartDefinition _createStatechartDefinition = StatechartModelFactory.eINSTANCE.createStatechartDefinition();
      final Procedure1<StatechartDefinition> _function_5 = (StatechartDefinition it_1) -> {
        it_1.setName(stmt.getName());
        EList<Port> _ports = it_1.getPorts();
        Port _createPort = StatechartModelFactory.eINSTANCE.createPort();
        final Procedure1<Port> _function_6 = (Port it_2) -> {
          it_2.setName("Block_Port");
          InterfaceRealization _createInterfaceRealization = StatechartModelFactory.eINSTANCE.createInterfaceRealization();
          final Procedure1<InterfaceRealization> _function_7 = (InterfaceRealization it_3) -> {
            it_3.setRealizationMode(RealizationMode.PROVIDED);
            it_3.setInterface(gInterface);
          };
          InterfaceRealization _doubleArrow = ObjectExtensions.<InterfaceRealization>operator_doubleArrow(_createInterfaceRealization, _function_7);
          it_2.setInterfaceRealization(_doubleArrow);
        };
        Port _doubleArrow = ObjectExtensions.<Port>operator_doubleArrow(_createPort, _function_6);
        _ports.add(_doubleArrow);
      };
      final StatechartDefinition gStatechart = ObjectExtensions.<StatechartDefinition>operator_doubleArrow(_createStatechartDefinition, _function_5);
      InterfaceTrace _createInterfaceTrace = TraceFactory.eINSTANCE.createInterfaceTrace();
      final Procedure1<InterfaceTrace> _function_6 = (InterfaceTrace it_1) -> {
        EList<EObject> _source = it_1.getSource();
        _source.add(mdBlock);
        EList<EObject> _target = it_1.getTarget();
        _target.add(gInterface);
      };
      final InterfaceTrace operationsInterfaceTrace = ObjectExtensions.<InterfaceTrace>operator_doubleArrow(_createInterfaceTrace, _function_6);
      Trace _createTrace = TraceFactory.eINSTANCE.createTrace();
      final Procedure1<Trace> _function_7 = (Trace it_1) -> {
        EList<EObject> _source = it_1.getSource();
        _source.add(mdBlock);
        EList<EObject> _target = it_1.getTarget();
        _target.add(gStatechart);
      };
      final Trace trace = ObjectExtensions.<Trace>operator_doubleArrow(_createTrace, _function_7);
      hu.bme.mit.gamma.statechart.model.Package _createPackage = StatechartModelFactory.eINSTANCE.createPackage();
      final Procedure1<hu.bme.mit.gamma.statechart.model.Package> _function_8 = (hu.bme.mit.gamma.statechart.model.Package it_1) -> {
        it_1.setName(this.formatter.fomratName(mdBlock.getName().toLowerCase()));
        EList<Component> _components = it_1.getComponents();
        _components.add(gStatechart);
        EList<Interface> _interfaces = it_1.getInterfaces();
        _interfaces.add(gInterface);
      };
      final hu.bme.mit.gamma.statechart.model.Package gPackage = ObjectExtensions.<hu.bme.mit.gamma.statechart.model.Package>operator_doubleArrow(_createPackage, _function_8);
      this.prepareStateMachine(stmt, gPackage, gStatechart);
      EList<AbstractTrace> _traces = this.traceRoot.getTraces();
      Iterables.<AbstractTrace>addAll(_traces, Collections.<AbstractTrace>unmodifiableList(CollectionLiterals.<AbstractTrace>newArrayList(trace, operationsInterfaceTrace)));
      this.gSet.add(gPackage);
    };
    IterableExtensions.<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>filter(this.mdSet, _function_2).forEach(_function_3);
    final HashSet<EObject> all = new HashSet<EObject>();
    Iterables.<EObject>addAll(all, this.mdSet);
    Iterables.<EObject>addAll(all, this.gSet);
    all.add(this.traceRoot);
    final BaseIndexOptions options = new BaseIndexOptions();
    final EMFScope scope = new EMFScope(all, options);
    InterfacePackage.eINSTANCE.getNsURI();
    final ViatraQueryEngine engine = ViatraQueryEngine.on(scope);
    final Tracer tracer = new Tracer(this.traceRoot, engine);
    final MagicdrawToGammaTransformer tra = new MagicdrawToGammaTransformer(engine, tracer);
    tra.execute();
    Pair<String, HashSet<hu.bme.mit.gamma.statechart.model.Package>> _mappedTo = Pair.<String, HashSet<hu.bme.mit.gamma.statechart.model.Package>>of("output", this.gSet);
    ArrayList<String> _message = tra.getMessage();
    Pair<String, ArrayList<String>> _mappedTo_1 = Pair.<String, ArrayList<String>>of("messages", _message);
    return Collections.<String, AbstractCollection<?>>unmodifiableMap(CollectionLiterals.<String, AbstractCollection<?>>newHashMap(_mappedTo, _mappedTo_1));
  }
  
  private boolean prepareStateMachine(final StateMachine mdStateMachine, final hu.bme.mit.gamma.statechart.model.Package gPackage, final StatechartDefinition gStatechart) {
    boolean _xblockexpression = false;
    {
      Interface _createInterface = InterfaceFactory.eINSTANCE.createInterface();
      final Procedure1<Interface> _function = (Interface it) -> {
        String _fomratName = this.formatter.fomratName(mdStateMachine.getName());
        String _plus = ("StateMachine_Interface_For_" + _fomratName);
        it.setName(_plus);
      };
      final Interface gInterface = ObjectExtensions.<Interface>operator_doubleArrow(_createInterface, _function);
      final Procedure1<StatechartDefinition> _function_1 = (StatechartDefinition it) -> {
        EList<Port> _ports = it.getPorts();
        Port _createPort = StatechartModelFactory.eINSTANCE.createPort();
        final Procedure1<Port> _function_2 = (Port it_1) -> {
          it_1.setName("StateMachine_Port");
          InterfaceRealization _createInterfaceRealization = StatechartModelFactory.eINSTANCE.createInterfaceRealization();
          final Procedure1<InterfaceRealization> _function_3 = (InterfaceRealization it_2) -> {
            it_2.setRealizationMode(RealizationMode.PROVIDED);
            it_2.setInterface(gInterface);
          };
          InterfaceRealization _doubleArrow = ObjectExtensions.<InterfaceRealization>operator_doubleArrow(_createInterfaceRealization, _function_3);
          it_1.setInterfaceRealization(_doubleArrow);
        };
        Port _doubleArrow = ObjectExtensions.<Port>operator_doubleArrow(_createPort, _function_2);
        _ports.add(_doubleArrow);
      };
      ObjectExtensions.<StatechartDefinition>operator_doubleArrow(gStatechart, _function_1);
      InterfaceTrace _createInterfaceTrace = TraceFactory.eINSTANCE.createInterfaceTrace();
      final Procedure1<InterfaceTrace> _function_2 = (InterfaceTrace it) -> {
        EList<EObject> _source = it.getSource();
        _source.add(mdStateMachine);
        EList<EObject> _target = it.getTarget();
        _target.add(gInterface);
      };
      final InterfaceTrace operationsInterfaceTrace = ObjectExtensions.<InterfaceTrace>operator_doubleArrow(_createInterfaceTrace, _function_2);
      Trace _createTrace = TraceFactory.eINSTANCE.createTrace();
      final Procedure1<Trace> _function_3 = (Trace it) -> {
        EList<EObject> _source = it.getSource();
        _source.add(mdStateMachine);
        EList<EObject> _target = it.getTarget();
        _target.add(gStatechart);
      };
      final Trace trace = ObjectExtensions.<Trace>operator_doubleArrow(_createTrace, _function_3);
      EList<Interface> _interfaces = gPackage.getInterfaces();
      _interfaces.add(gInterface);
      EList<AbstractTrace> _traces = this.traceRoot.getTraces();
      _xblockexpression = Iterables.<AbstractTrace>addAll(_traces, Collections.<AbstractTrace>unmodifiableList(CollectionLiterals.<AbstractTrace>newArrayList(trace, operationsInterfaceTrace)));
    }
    return _xblockexpression;
  }
}
