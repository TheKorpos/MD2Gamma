package hu.bme.mit.md2g.util.profile;

import com.nomagic.uml2.ext.jmi.helpers.StereotypeByProfileCache;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.EnumerationLiteral;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Enumeration;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.DataType;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.uml.BaseElement;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

@SuppressWarnings("WeakerAccess")
public class Gamma extends StereotypeByProfileCache
{
    public static final String PROFILE_URI = "";

    public static final String PROFILE_NAME = "Gamma";

    public static Gamma getInstance(@Nonnull BaseElement element)
    {
        return getInstance(Project.getProject(element));
    }

    public Gamma(@Nonnull Project project)
    {
        super(project, PROFILE_NAME, PROFILE_URI);
    }

    public static Gamma getInstance(@Nonnull Project project)
    {
        Gamma instance = getInternalInstance(Gamma.class, project);
        if (instance == null)
        {
            instance = new Gamma(project);
        }
        return instance;
    }



@SuppressWarnings("UnusedDeclaration")
public static final String OPARETOR_DATATYPE = "Oparetor";
@SuppressWarnings("UnusedDeclaration")
public static final String RESULTTYPE_DATATYPE = "ResultType";

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Enumeration getOparetor()
{
return (Enumeration) getDataType(OPARETOR_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Enumeration getResultType()
{
return (Enumeration) getDataType(RESULTTYPE_DATATYPE);
}

@SuppressWarnings("UnusedDeclaration")
public static final String OPARETOR_LEADS_TO_LITERAL = "Leads To";
@SuppressWarnings("UnusedDeclaration")
public static final String OPARETOR_MIGHT_ALWAYS_LITERAL = "Might Always";
@SuppressWarnings("UnusedDeclaration")
public static final String OPARETOR_MIGHT_EVENTUALLY_LITERAL = "Might Eventually";
@SuppressWarnings("UnusedDeclaration")
public static final String OPARETOR_MUST_ALWAYS_LITERAL = "Must Always";
@SuppressWarnings("UnusedDeclaration")
public static final String OPARETOR_MUST_EVENTUALLY_LITERAL = "Must Eventually";
public enum OparetorEnum {
MUST_ALWAYS(OPARETOR_MUST_ALWAYS_LITERAL),
MIGHT_EVENTUALLY(OPARETOR_MIGHT_EVENTUALLY_LITERAL),
MIGHT_ALWAYS(OPARETOR_MIGHT_ALWAYS_LITERAL),
LEADS_TO(OPARETOR_LEADS_TO_LITERAL),
MUST_EVENTUALLY(OPARETOR_MUST_EVENTUALLY_LITERAL);
        private String text;

       OparetorEnum(String text)
        {
            this.text = text;
        }

        public String getText()
        {
            return this.text;
        }
@CheckForNull
        public static OparetorEnum from(@CheckForNull Object o) {
  String text = null;
  if(o instanceof EnumerationLiteral)  {
       text = ((EnumerationLiteral)o).getName();
   }
   else if(o != null){text = o.toString();}
            if (text != null) {
                for (OparetorEnum b : OparetorEnum.values()) {
                    if (text.equals(b.text)) {
                        return b;
                    }
                }
            }
            return null;
        }
}

@SuppressWarnings("UnusedDeclaration")
public static final String RESULTTYPE_NOT_CHECKED_LITERAL = "Not Checked";
@SuppressWarnings("UnusedDeclaration")
public static final String RESULTTYPE_SATISFIED_LITERAL = "Satisfied";
@SuppressWarnings("UnusedDeclaration")
public static final String RESULTTYPE_VIOLATED_LITERAL = "Violated";
public enum ResultTypeEnum {
NOT_CHECKED(RESULTTYPE_NOT_CHECKED_LITERAL),
SATISFIED(RESULTTYPE_SATISFIED_LITERAL),
VIOLATED(RESULTTYPE_VIOLATED_LITERAL);
        private String text;

       ResultTypeEnum(String text)
        {
            this.text = text;
        }

        public String getText()
        {
            return this.text;
        }
@CheckForNull
        public static ResultTypeEnum from(@CheckForNull Object o) {
  String text = null;
  if(o instanceof EnumerationLiteral)  {
       text = ((EnumerationLiteral)o).getName();
   }
   else if(o != null){text = o.toString();}
            if (text != null) {
                for (ResultTypeEnum b : ResultTypeEnum.values()) {
                    if (text.equals(b.text)) {
                        return b;
                    }
                }
            }
            return null;
        }
}


public static class Act extends AbstractStereotypeWrapper {


//stereotype Act and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Act";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getAct()
{
return getStereotype(Act.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isAct(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getAct());
}
return false;
}

public static class ActGroup extends AbstractStereotypeWrapper {


//stereotype ActGroup and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ActGroup";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getActGroup()
{
return getStereotype(ActGroup.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isActGroup(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getActGroup());
}
return false;
}

public static class AsynchronousComponent extends AbstractStereotypeWrapper {


//stereotype AsynchronousComponent and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "AsynchronousComponent";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getAsynchronousComponent()
{
return getStereotype(AsynchronousComponent.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isAsynchronousComponent(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getAsynchronousComponent());
}
return false;
}

public static class AsynchronousCompositeComponent extends AbstractStereotypeWrapper {


//stereotype AsynchronousCompositeComponent and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "AsynchronousCompositeComponent";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getAsynchronousCompositeComponent()
{
return getStereotype(AsynchronousCompositeComponent.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isAsynchronousCompositeComponent(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getAsynchronousCompositeComponent());
}
return false;
}

public static class AsynchronousStatechartDefinition extends AbstractStereotypeWrapper {


//stereotype AsynchronousStatechartDefinition and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "AsynchronousStatechartDefinition";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getAsynchronousStatechartDefinition()
{
return getStereotype(AsynchronousStatechartDefinition.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isAsynchronousStatechartDefinition(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getAsynchronousStatechartDefinition());
}
return false;
}

public static class CascadeCompositeComponent extends AbstractStereotypeWrapper {


//stereotype CascadeCompositeComponent and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "CascadeCompositeComponent";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getCascadeCompositeComponent()
{
return getStereotype(CascadeCompositeComponent.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isCascadeCompositeComponent(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getCascadeCompositeComponent());
}
return false;
}

public static class ComponentSchedule extends AbstractStereotypeWrapper {


//stereotype ComponentSchedule and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ComponentSchedule";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getComponentSchedule()
{
return getStereotype(ComponentSchedule.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isComponentSchedule(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getComponentSchedule());
}
return false;
}

public static class Cycle extends AbstractStereotypeWrapper {


//stereotype Cycle and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Cycle";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getCycle()
{
return getStereotype(Cycle.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isCycle(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getCycle());
}
return false;
}

public static class GammaCheck extends AbstractStereotypeWrapper {


//stereotype GammaCheck and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "GammaCheck";
@SuppressWarnings("UnusedDeclaration")
public static final String PROPERTIES = "properties";
@SuppressWarnings("UnusedDeclaration")
public static void setProperties(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getGammaCheck(), PROPERTIES, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearProperties(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getGammaCheck(), PROPERTIES, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addProperties(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getGammaCheck(), PROPERTIES, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeProperties(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getProperties(element));
values.remove(value);
setProperties(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getProperties(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getGammaCheck(), PROPERTIES));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getGammaCheck()
{
return getStereotype(GammaCheck.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isGammaCheck(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getGammaCheck());
}
return false;
}

public static class GammaComponent extends AbstractStereotypeWrapper {


//stereotype GammaComponent and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "GammaComponent";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getGammaComponent()
{
return getStereotype(GammaComponent.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isGammaComponent(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getGammaComponent());
}
return false;
}

public static class GammaProperty extends AbstractStereotypeWrapper {


//stereotype GammaProperty and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "GammaProperty";
@SuppressWarnings("UnusedDeclaration")
public static final String OPERATOR = "operator";
@SuppressWarnings("UnusedDeclaration")
public static final String RESULT = "result";
@SuppressWarnings("UnusedDeclaration")
public static void setOperator(Element element, OparetorEnum value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getGammaProperty(), OPERATOR, value != null ? value.getText() : null);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearOperator(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getGammaProperty(), OPERATOR, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static OparetorEnum getOperator(Element element){
return OparetorEnum.from(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getGammaProperty(), OPERATOR));
}

@SuppressWarnings("UnusedDeclaration")
public static void setResult(Element element, ResultTypeEnum value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getGammaProperty(), RESULT, value != null ? value.getText() : null);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearResult(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getGammaProperty(), RESULT, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static ResultTypeEnum getResult(Element element){
return ResultTypeEnum.from(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getGammaProperty(), RESULT));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getGammaProperty()
{
return getStereotype(GammaProperty.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isGammaProperty(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.OpaqueBehavior){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getGammaProperty());
}
return false;
}

public static class GammaWorkspace extends AbstractStereotypeWrapper {


//stereotype GammaWorkspace and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "GammaWorkspace";
@SuppressWarnings("UnusedDeclaration")
public static final String COUNTER_EXAMPLES = "counter examples";
@SuppressWarnings("UnusedDeclaration")
public static final String COUNTER_EXAMPLES_PACKAGE = "counter examples package";
@SuppressWarnings("UnusedDeclaration")
public static final String TARGET = "target";
@SuppressWarnings("UnusedDeclaration")
public static final String WORKSPACEURI = "workspaceUri";
@SuppressWarnings("UnusedDeclaration")
public static void setCounterexamples(Element element, Boolean value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getGammaWorkspace(), COUNTER_EXAMPLES, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearCounterexamples(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getGammaWorkspace(), COUNTER_EXAMPLES, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Boolean isCounterexamples(Element element){
return toBoolean(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getGammaWorkspace(), COUNTER_EXAMPLES));
}

@SuppressWarnings("UnusedDeclaration")
public static void setCounterexamplespackage(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getGammaWorkspace(), COUNTER_EXAMPLES_PACKAGE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearCounterexamplespackage(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getGammaWorkspace(), COUNTER_EXAMPLES_PACKAGE, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getCounterexamplespackage(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getGammaWorkspace(), COUNTER_EXAMPLES_PACKAGE));
}

@SuppressWarnings("UnusedDeclaration")
public static void setTarget(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getGammaWorkspace(), TARGET, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearTarget(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getGammaWorkspace(), TARGET, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getTarget(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getGammaWorkspace(), TARGET));
}

@SuppressWarnings("UnusedDeclaration")
public static void setWorkspaceUri(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getGammaWorkspace(), WORKSPACEURI, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearWorkspaceUri(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getGammaWorkspace(), WORKSPACEURI, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getWorkspaceUri(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getGammaWorkspace(), WORKSPACEURI));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getGammaWorkspace()
{
return getStereotype(GammaWorkspace.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isGammaWorkspace(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getGammaWorkspace());
}
return false;
}

public static class GammaWorkspaceFile extends AbstractStereotypeWrapper {


//stereotype GammaWorkspaceFile and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "GammaWorkspaceFile";
@SuppressWarnings("UnusedDeclaration")
public static final String WORKSPACERELATIVEURI = "workspaceRelativeUri";
@SuppressWarnings("UnusedDeclaration")
public static void setWorkspaceRelativeUri(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getGammaWorkspaceFile(), WORKSPACERELATIVEURI, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearWorkspaceRelativeUri(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getGammaWorkspaceFile(), WORKSPACERELATIVEURI, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getWorkspaceRelativeUri(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getGammaWorkspaceFile(), WORKSPACERELATIVEURI));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getGammaWorkspaceFile()
{
return getStereotype(GammaWorkspaceFile.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isGammaWorkspaceFile(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getGammaWorkspaceFile());
}
return false;
}

public static class InstanceState extends AbstractStereotypeWrapper {


//stereotype InstanceState and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "InstanceState";
@SuppressWarnings("UnusedDeclaration")
public static final String REFERENCEDPART = "referencedPart";
@SuppressWarnings("UnusedDeclaration")
public static void setReferencedPart(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getInstanceState(), REFERENCEDPART, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearReferencedPart(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getInstanceState(), REFERENCEDPART, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getReferencedPart(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getInstanceState(), REFERENCEDPART));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getInstanceState()
{
return getStereotype(InstanceState.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isInstanceState(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getInstanceState());
}
return false;
}

public static class InstanceStateConstant extends AbstractStereotypeWrapper {


//stereotype InstanceStateConstant and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "InstanceStateConstant";
@SuppressWarnings("UnusedDeclaration")
public static final String REFERENCEDSTATE = "referencedState";
@SuppressWarnings("UnusedDeclaration")
public static void setReferencedState(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getInstanceStateConstant(), REFERENCEDSTATE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearReferencedState(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getInstanceStateConstant(), REFERENCEDSTATE, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getReferencedState(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getInstanceStateConstant(), REFERENCEDSTATE));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getInstanceStateConstant()
{
return getStereotype(InstanceStateConstant.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isInstanceStateConstant(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getInstanceStateConstant());
}
return false;
}

public static class InstanceVariableState extends AbstractStereotypeWrapper {


//stereotype InstanceVariableState and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "InstanceVariableState";
@SuppressWarnings("UnusedDeclaration")
public static final String REFERENCEDVARIABLE = "referencedVariable";
@SuppressWarnings("UnusedDeclaration")
public static void setReferencedVariable(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getInstanceVariableState(), REFERENCEDVARIABLE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearReferencedVariable(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getInstanceVariableState(), REFERENCEDVARIABLE, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getReferencedVariable(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getInstanceVariableState(), REFERENCEDVARIABLE));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getInstanceVariableState()
{
return getStereotype(InstanceVariableState.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isInstanceVariableState(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getInstanceVariableState());
}
return false;
}

public static class MD2G_Trace extends AbstractStereotypeWrapper {


//stereotype MD2G_Trace and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "MD2G_Trace";
@SuppressWarnings("UnusedDeclaration")
public static final String URIFRAGMENT = "URIFragment";
@SuppressWarnings("UnusedDeclaration")
public static void setURIFragment(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getMD2G_Trace(), URIFRAGMENT, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearURIFragment(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getMD2G_Trace(), URIFRAGMENT, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getURIFragment(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getMD2G_Trace(), URIFRAGMENT));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getMD2G_Trace()
{
return getStereotype(MD2G_Trace.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isMD2G_Trace(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getMD2G_Trace());
}
return false;
}

public static class RaiseEventAct extends AbstractStereotypeWrapper {


//stereotype RaiseEventAct and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "RaiseEventAct";
@SuppressWarnings("UnusedDeclaration")
public static final String REFERENCEDACTION = "referencedAction";
@SuppressWarnings("UnusedDeclaration")
public static void setReferencedAction(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getRaiseEventAct(), REFERENCEDACTION, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearReferencedAction(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getRaiseEventAct(), REFERENCEDACTION, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getReferencedAction(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getRaiseEventAct(), REFERENCEDACTION));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getRaiseEventAct()
{
return getStereotype(RaiseEventAct.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isRaiseEventAct(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getRaiseEventAct());
}
return false;
}

public static class Satisfied extends AbstractStereotypeWrapper {


//stereotype Satisfied and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Satisfied";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSatisfied()
{
return getStereotype(Satisfied.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSatisfied(@CheckForNull Element element)
{
if(element !=null){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getSatisfied());
}
return false;
}

public static class Schedule extends AbstractStereotypeWrapper {


//stereotype Schedule and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Schedule";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSchedule()
{
return getStereotype(Schedule.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSchedule(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getSchedule());
}
return false;
}

public static class StatechartDefinition extends AbstractStereotypeWrapper {


//stereotype StatechartDefinition and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "StatechartDefinition";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getStatechartDefinition()
{
return getStereotype(StatechartDefinition.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isStatechartDefinition(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getStatechartDefinition());
}
return false;
}

public static class Step extends AbstractStereotypeWrapper {


//stereotype Step and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Step";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getStep()
{
return getStereotype(Step.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isStep(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getStep());
}
return false;
}

public static class SynchronousComponent extends AbstractStereotypeWrapper {


//stereotype SynchronousComponent and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "SynchronousComponent";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSynchronousComponent()
{
return getStereotype(SynchronousComponent.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSynchronousComponent(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getSynchronousComponent());
}
return false;
}

public static class SynchrounousCompositeComponent extends AbstractStereotypeWrapper {


//stereotype SynchrounousCompositeComponent and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "SynchrounousCompositeComponent";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSynchrounousCompositeComponent()
{
return getStereotype(SynchrounousCompositeComponent.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSynchrounousCompositeComponent(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getSynchrounousCompositeComponent());
}
return false;
}

public static class TimeElapse extends AbstractStereotypeWrapper {


//stereotype TimeElapse and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "TimeElapse";
@SuppressWarnings("UnusedDeclaration")
public static final String VALUE = "value";
@SuppressWarnings("UnusedDeclaration")
public static void setValue(Element element, Integer value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getTimeElapse(), VALUE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearValue(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getTimeElapse(), VALUE, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Integer getValue(Element element){
return toInteger(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getTimeElapse(), VALUE));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getTimeElapse()
{
return getStereotype(TimeElapse.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isTimeElapse(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getTimeElapse());
}
return false;
}

public static class Violated extends AbstractStereotypeWrapper {


//stereotype Violated and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Violated";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getViolated()
{
return getStereotype(Violated.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isViolated(@CheckForNull Element element)
{
if(element !=null){
Gamma instance=getInstance(element);
return instance.isTypeOf(element, instance.getViolated());
}
return false;
}



@Override
protected Collection<Stereotype> generatedGetAllStereotypes()
{
if (getProfile() != null)
{
final Collection<Stereotype> stereotypes = new HashSet<>();

stereotypes.add(getAct());
stereotypes.add(getActGroup());
stereotypes.add(getAsynchronousComponent());
stereotypes.add(getAsynchronousCompositeComponent());
stereotypes.add(getAsynchronousStatechartDefinition());
stereotypes.add(getCascadeCompositeComponent());
stereotypes.add(getComponentSchedule());
stereotypes.add(getCycle());
stereotypes.add(getGammaCheck());
stereotypes.add(getGammaComponent());
stereotypes.add(getGammaProperty());
stereotypes.add(getGammaWorkspace());
stereotypes.add(getGammaWorkspaceFile());
stereotypes.add(getInstanceState());
stereotypes.add(getInstanceStateConstant());
stereotypes.add(getInstanceVariableState());
stereotypes.add(getMD2G_Trace());
stereotypes.add(getRaiseEventAct());
stereotypes.add(getSatisfied());
stereotypes.add(getSchedule());
stereotypes.add(getStatechartDefinition());
stereotypes.add(getStep());
stereotypes.add(getSynchronousComponent());
stereotypes.add(getSynchrounousCompositeComponent());
stereotypes.add(getTimeElapse());
stereotypes.add(getViolated());

return stereotypes;
}

return super.generatedGetAllStereotypes();
}

}
//MD5sum:BF464B6551EB9CB5EF2A0A6DF071D4D8