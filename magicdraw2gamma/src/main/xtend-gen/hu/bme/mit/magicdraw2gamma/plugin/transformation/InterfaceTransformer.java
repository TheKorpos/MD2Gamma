package hu.bme.mit.magicdraw2gamma.plugin.transformation;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Operation;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Parameter;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Reception;
import hu.bme.mit.gamma.constraint.model.ConstraintModelFactory;
import hu.bme.mit.gamma.constraint.model.IntegerTypeDefinition;
import hu.bme.mit.gamma.constraint.model.ParameterDeclaration;
import hu.bme.mit.gamma.statechart.model.interface_.Event;
import hu.bme.mit.gamma.statechart.model.interface_.EventDeclaration;
import hu.bme.mit.gamma.statechart.model.interface_.EventDirection;
import hu.bme.mit.gamma.statechart.model.interface_.Interface;
import hu.bme.mit.gamma.statechart.model.interface_.InterfaceFactory;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class InterfaceTransformer {
  @Extension
  protected InterfaceFactory interfaceFactory = InterfaceFactory.eINSTANCE;
  
  @Extension
  protected ConstraintModelFactory constraintModelFactory = ConstraintModelFactory.eINSTANCE;
  
  @Extension
  protected Tracer tracer;
  
  private final Collection<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> mdClasses;
  
  public InterfaceTransformer(final Collection<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> mdClasses, final Tracer tracer) {
    this.mdClasses = mdClasses;
    this.tracer = tracer;
  }
  
  public void transform() {
    final Consumer<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> _function = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class it) -> {
      this.transform(it);
    };
    this.mdClasses.forEach(_function);
  }
  
  private Interface transform(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class mdClass) {
    Interface _createInterface = this.interfaceFactory.createInterface();
    final Procedure1<Interface> _function = (Interface it) -> {
      String _name = mdClass.getName();
      String _plus = ("I" + _name);
      it.setName(_plus);
    };
    final Interface gInterface = ObjectExtensions.<Interface>operator_doubleArrow(_createInterface, _function);
    final List<Operation> mdOperations = mdClass.getOwnedOperation();
    final Consumer<Operation> _function_1 = (Operation it) -> {
      final Operation mdOperation = it;
      Event _createEvent = this.interfaceFactory.createEvent();
      final Procedure1<Event> _function_2 = (Event it_1) -> {
        String _name = mdOperation.getName();
        String _plus = ("operationCall_" + _name);
        it_1.setName(_plus);
      };
      final Event gEvent = ObjectExtensions.<Event>operator_doubleArrow(_createEvent, _function_2);
      final Consumer<Parameter> _function_3 = (Parameter it_1) -> {
        final Parameter mdParameter = it_1;
        EList<ParameterDeclaration> _parameterDeclarations = gEvent.getParameterDeclarations();
        ParameterDeclaration _createParameterDeclaration = this.constraintModelFactory.createParameterDeclaration();
        final Procedure1<ParameterDeclaration> _function_4 = (ParameterDeclaration it_2) -> {
          it_2.setName(mdParameter.getName());
          it_2.setType(this.transformParameterType(mdParameter));
        };
        ParameterDeclaration _doubleArrow = ObjectExtensions.<ParameterDeclaration>operator_doubleArrow(_createParameterDeclaration, _function_4);
        _parameterDeclarations.add(_doubleArrow);
      };
      mdOperation.getOwnedParameter().forEach(_function_3);
      EList<EventDeclaration> _events = gInterface.getEvents();
      EventDeclaration _createEventDeclaration = this.interfaceFactory.createEventDeclaration();
      final Procedure1<EventDeclaration> _function_4 = (EventDeclaration it_1) -> {
        it_1.setEvent(gEvent);
        it_1.setDirection(EventDirection.IN);
      };
      EventDeclaration _doubleArrow = ObjectExtensions.<EventDeclaration>operator_doubleArrow(_createEventDeclaration, _function_4);
      _events.add(_doubleArrow);
      this.tracer.createOnetToManyTrace(mdOperation, Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(gInterface, gEvent)));
    };
    mdOperations.forEach(_function_1);
    final Collection<Reception> mdSignalReceptions = mdClass.getOwnedReception();
    final Consumer<Reception> _function_2 = (Reception it) -> {
      final Reception mdReception = it;
      Event _createEvent = this.interfaceFactory.createEvent();
      final Procedure1<Event> _function_3 = (Event it_1) -> {
        String _name = mdReception.getName();
        String _plus = ("singalReceptionCall_" + _name);
        it_1.setName(_plus);
      };
      final Event gEvent = ObjectExtensions.<Event>operator_doubleArrow(_createEvent, _function_3);
      EList<EventDeclaration> _events = gInterface.getEvents();
      EventDeclaration _createEventDeclaration = this.interfaceFactory.createEventDeclaration();
      final Procedure1<EventDeclaration> _function_4 = (EventDeclaration it_1) -> {
        it_1.setEvent(gEvent);
        it_1.setDirection(EventDirection.IN);
      };
      EventDeclaration _doubleArrow = ObjectExtensions.<EventDeclaration>operator_doubleArrow(_createEventDeclaration, _function_4);
      _events.add(_doubleArrow);
    };
    mdSignalReceptions.forEach(_function_2);
    return gInterface;
  }
  
  private IntegerTypeDefinition transformParameterType(final Parameter parameter) {
    try {
      final String typeName = parameter.getType().getName();
      if (typeName != null) {
        switch (typeName) {
          case "Integer":
            return this.constraintModelFactory.createIntegerTypeDefinition();
          default:
            throw new Exception((typeName + " type not supported"));
        }
      } else {
        throw new Exception((typeName + " type not supported"));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
