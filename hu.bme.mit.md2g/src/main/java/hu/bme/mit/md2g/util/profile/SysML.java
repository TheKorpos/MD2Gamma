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
public class SysML extends StereotypeByProfileCache
{
    public static final String PROFILE_URI = "http://www.omg.org/spec/SysML/20150709/SysML";

    public static final String PROFILE_NAME = "SysML";

    public static SysML getInstance(@Nonnull BaseElement element)
    {
        return getInstance(Project.getProject(element));
    }

    public SysML(@Nonnull Project project)
    {
        super(project, PROFILE_NAME, PROFILE_URI);
    }

    public static SysML getInstance(@Nonnull Project project)
    {
        SysML instance = getInternalInstance(SysML.class, project);
        if (instance == null)
        {
            instance = new SysML(project);
        }
        return instance;
    }



@SuppressWarnings("UnusedDeclaration")
public static final String BOOLEAN_DATATYPE = "Boolean";

/**
* A Complex value type represents the mathematical concept of a complex number. A complex number consists of a real part defined by a real number, and an imaginary part defined by a real number multiplied by the square root of -1. Complex numbers are used to express solutions to various forms of mathematical equations.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String COMPLEX_DATATYPE = "Complex";

/**
* The ControlValue enumeration is a type for treating control values as data and for UML control pins. It can be used as the type of behavior and operation parameters, object nodes, and attributes, and so on. The possible runtime values are given as enumeration literals. Modelers can extend the enumeration with additional literals, such as suspend, resume, with their own semantics.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String CONTROLVALUE_DATATYPE = "ControlValue";
@SuppressWarnings("UnusedDeclaration")
public static final String FEATUREDIRECTION_DATATYPE = "FeatureDirection";

/**
* FlowDirection is an enumeration type that defines literals used for specifying input and output directions. FlowDirection is used by flow properties to indicate if a property is an input or an output with respect to its owner.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String FLOWDIRECTION_DATATYPE = "FlowDirection";
@SuppressWarnings("UnusedDeclaration")
public static final String INTEGER_DATATYPE = "Integer";
@SuppressWarnings("UnusedDeclaration")
public static final String NUMBER_DATATYPE = "Number";

/**
* A Real value type represents the mathematical concept of a real number. A Real value type may be used to type values that hold continuous quantities, without committing a specific representation such as a floating point data type with restrictions on precision and scale.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String REAL_DATATYPE = "Real";

/**
* 1) High indicates an unacceptable level of risk, 
2) Medium indicates an acceptable level of risk, and
3) Low indicates a minimal level of risk or no risk
*/
@SuppressWarnings("UnusedDeclaration")
public static final String RISKKIND_DATATYPE = "RiskKind";
@SuppressWarnings("UnusedDeclaration")
public static final String STRING_DATATYPE = "String";
@SuppressWarnings("UnusedDeclaration")
public static final String UNLIMITEDNATURAL_DATATYPE = "UnlimitedNatural";

/**
* Type of a return parameter of a TestCase must be VerdictKind, consistent with the UML Testing Profile.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String VERDICTKIND_DATATYPE = "VerdictKind";

/**
* 1) Analysis indicates that verification will be performed by technical evaluation using mathematical representations, charts, graphs, circuit diagrams, data reduction, or representative data. Analysis also includes the verification of requirements under conditions, which are simulated or modeled; where the results are derived from the analysis of the results produced by the model,
2) Demonstration indicates that verification will be performed by operation, movement or adjustment of the item under specific conditions to perform the design functions without recording of quantitative data. Demonstration is typically considered the least restrictive of the verification types,
3) Inspection indicates that verification will be performed by examination of the item, reviewing descriptive documentation, and comparing the appropriate characteristics with a predetermined standard to determine conformance to requirements without the use of special laboratory equipment or procedures, and
4) Test indicates that verification will be performed through systematic exercising of the applicable item under appropriate conditions with instrumentation to measure required parameters and the collection, analysis, and evaluation of quantitative data to show that measured parameters equal or exceed specified requirements.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String VERIFICATIONMETHODKIND_DATATYPE = "VerificationMethodKind";

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public DataType getBoolean()
{
return (DataType) getDataType(BOOLEAN_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public DataType getComplex()
{
return (DataType) getDataType(COMPLEX_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Enumeration getControlValue()
{
return (Enumeration) getDataType(CONTROLVALUE_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Enumeration getFeatureDirection()
{
return (Enumeration) getDataType(FEATUREDIRECTION_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Enumeration getFlowDirection()
{
return (Enumeration) getDataType(FLOWDIRECTION_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public DataType getInteger()
{
return (DataType) getDataType(INTEGER_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public DataType getNumber()
{
return (DataType) getDataType(NUMBER_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public DataType getReal()
{
return (DataType) getDataType(REAL_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Enumeration getRiskKind()
{
return (Enumeration) getDataType(RISKKIND_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public DataType getString()
{
return (DataType) getDataType(STRING_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public DataType getUnlimitedNatural()
{
return (DataType) getDataType(UNLIMITEDNATURAL_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Enumeration getVerdictKind()
{
return (Enumeration) getDataType(VERDICTKIND_DATATYPE);
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Enumeration getVerificationMethodKind()
{
return (Enumeration) getDataType(VERIFICATIONMETHODKIND_DATATYPE);
}


/**
* The disable literal means a termination of an executing behavior that can only be started again from the beginning (compare to suspend).
*/
@SuppressWarnings("UnusedDeclaration")
public static final String CONTROLVALUE_DISABLE_LITERAL = "disable";

/**
* The enable literal means to start a new execution of a behavior (compare to resume).
*/
@SuppressWarnings("UnusedDeclaration")
public static final String CONTROLVALUE_ENABLE_LITERAL = "enable";
public enum ControlValueEnum {
DISABLE(CONTROLVALUE_DISABLE_LITERAL),
ENABLE(CONTROLVALUE_ENABLE_LITERAL);
        private String text;

       ControlValueEnum(String text)
        {
            this.text = text;
        }

        public String getText()
        {
            return this.text;
        }
@CheckForNull
        public static ControlValueEnum from(@CheckForNull Object o) {
  String text = null;
  if(o instanceof EnumerationLiteral)  {
       text = ((EnumerationLiteral)o).getName();
   }
   else if(o != null){text = o.toString();}
            if (text != null) {
                for (ControlValueEnum b : ControlValueEnum.values()) {
                    if (text.equals(b.text)) {
                        return b;
                    }
                }
            }
            return null;
        }
}

@SuppressWarnings("UnusedDeclaration")
public static final String FEATUREDIRECTION_PROVIDEDREQUIRED_LITERAL = "providedRequired";
@SuppressWarnings("UnusedDeclaration")
public static final String FEATUREDIRECTION_PROVIDED_LITERAL = "provided";
@SuppressWarnings("UnusedDeclaration")
public static final String FEATUREDIRECTION_REQUIRED_LITERAL = "required";
public enum FeatureDirectionEnum {
PROVIDED(FEATUREDIRECTION_PROVIDED_LITERAL),
REQUIRED(FEATUREDIRECTION_REQUIRED_LITERAL),
PROVIDEDREQUIRED(FEATUREDIRECTION_PROVIDEDREQUIRED_LITERAL);
        private String text;

       FeatureDirectionEnum(String text)
        {
            this.text = text;
        }

        public String getText()
        {
            return this.text;
        }
@CheckForNull
        public static FeatureDirectionEnum from(@CheckForNull Object o) {
  String text = null;
  if(o instanceof EnumerationLiteral)  {
       text = ((EnumerationLiteral)o).getName();
   }
   else if(o != null){text = o.toString();}
            if (text != null) {
                for (FeatureDirectionEnum b : FeatureDirectionEnum.values()) {
                    if (text.equals(b.text)) {
                        return b;
                    }
                }
            }
            return null;
        }
}


/**
* Indicates that the flow property is an output of the owning block.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String FLOWDIRECTION_OUT_LITERAL = "out";

/**
* Indicates that the flow property is both an input and an output of the owning block.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String FLOWDIRECTION_INOUT_LITERAL = "inout";

/**
* Indicates that the flow property is input to the owning block.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String FLOWDIRECTION_IN_LITERAL = "in";
public enum FlowDirectionEnum {
IN(FLOWDIRECTION_IN_LITERAL),
OUT(FLOWDIRECTION_OUT_LITERAL),
INOUT(FLOWDIRECTION_INOUT_LITERAL);
        private String text;

       FlowDirectionEnum(String text)
        {
            this.text = text;
        }

        public String getText()
        {
            return this.text;
        }
@CheckForNull
        public static FlowDirectionEnum from(@CheckForNull Object o) {
  String text = null;
  if(o instanceof EnumerationLiteral)  {
       text = ((EnumerationLiteral)o).getName();
   }
   else if(o != null){text = o.toString();}
            if (text != null) {
                for (FlowDirectionEnum b : FlowDirectionEnum.values()) {
                    if (text.equals(b.text)) {
                        return b;
                    }
                }
            }
            return null;
        }
}


/**
* High indicates an unacceptable level of risk
*/
@SuppressWarnings("UnusedDeclaration")
public static final String RISKKIND_HIGH_LITERAL = "High";

/**
* Low indicates a minimal level of risk or no risk
*/
@SuppressWarnings("UnusedDeclaration")
public static final String RISKKIND_LOW_LITERAL = "Low";

/**
* Medium indicates an acceptable level of risk
*/
@SuppressWarnings("UnusedDeclaration")
public static final String RISKKIND_MEDIUM_LITERAL = "Medium";
public enum RiskKindEnum {
HIGH(RISKKIND_HIGH_LITERAL),
MEDIUM(RISKKIND_MEDIUM_LITERAL),
LOW(RISKKIND_LOW_LITERAL);
        private String text;

       RiskKindEnum(String text)
        {
            this.text = text;
        }

        public String getText()
        {
            return this.text;
        }
@CheckForNull
        public static RiskKindEnum from(@CheckForNull Object o) {
  String text = null;
  if(o instanceof EnumerationLiteral)  {
       text = ((EnumerationLiteral)o).getName();
   }
   else if(o != null){text = o.toString();}
            if (text != null) {
                for (RiskKindEnum b : RiskKindEnum.values()) {
                    if (text.equals(b.text)) {
                        return b;
                    }
                }
            }
            return null;
        }
}

@SuppressWarnings("UnusedDeclaration")
public static final String VERDICTKIND_ERROR_LITERAL = "error";
@SuppressWarnings("UnusedDeclaration")
public static final String VERDICTKIND_FAIL_LITERAL = "fail";
@SuppressWarnings("UnusedDeclaration")
public static final String VERDICTKIND_INCONCLUSIVE_LITERAL = "inconclusive";
@SuppressWarnings("UnusedDeclaration")
public static final String VERDICTKIND_PASS_LITERAL = "pass";
public enum VerdictKindEnum {
PASS(VERDICTKIND_PASS_LITERAL),
FAIL(VERDICTKIND_FAIL_LITERAL),
INCONCLUSIVE(VERDICTKIND_INCONCLUSIVE_LITERAL),
ERROR(VERDICTKIND_ERROR_LITERAL);
        private String text;

       VerdictKindEnum(String text)
        {
            this.text = text;
        }

        public String getText()
        {
            return this.text;
        }
@CheckForNull
        public static VerdictKindEnum from(@CheckForNull Object o) {
  String text = null;
  if(o instanceof EnumerationLiteral)  {
       text = ((EnumerationLiteral)o).getName();
   }
   else if(o != null){text = o.toString();}
            if (text != null) {
                for (VerdictKindEnum b : VerdictKindEnum.values()) {
                    if (text.equals(b.text)) {
                        return b;
                    }
                }
            }
            return null;
        }
}


/**
* Analysis indicates that verification will be performed by technical evaluation using mathematical representations, charts, graphs, circuit diagrams, data reduction, or representative data. Analysis also includes the verification of requirements under conditions, which are simulated or modeled; where the results are derived from the analysis of the results produced by the model
*/
@SuppressWarnings("UnusedDeclaration")
public static final String VERIFICATIONMETHODKIND_ANALYSIS_LITERAL = "Analysis";

/**
* Demonstration indicates that verification will be performed by operation, movement or adjustment of the item under specific conditions to perform the design functions without recording of quantitative data. Demonstration is typically considered the least restrictive of the verification types
*/
@SuppressWarnings("UnusedDeclaration")
public static final String VERIFICATIONMETHODKIND_DEMONSTRATION_LITERAL = "Demonstration";

/**
* Inspection indicates that verification will be performed by examination of the item, reviewing descriptive documentation, and comparing the appropriate characteristics with a predetermined standard to determine conformance to requirements without the use of special laboratory equipment or procedures
*/
@SuppressWarnings("UnusedDeclaration")
public static final String VERIFICATIONMETHODKIND_INSPECTION_LITERAL = "Inspection";

/**
* Test indicates that verification will be performed through systematic exercising of the applicable item under appropriate conditions with instrumentation to measure required parameters and the collection, analysis, and evaluation of quantitative data to show that measured parameters equal or exceed specified requirements
*/
@SuppressWarnings("UnusedDeclaration")
public static final String VERIFICATIONMETHODKIND_TEST_LITERAL = "Test";
public enum VerificationMethodKindEnum {
ANALYSIS(VERIFICATIONMETHODKIND_ANALYSIS_LITERAL),
DEMONSTRATION(VERIFICATIONMETHODKIND_DEMONSTRATION_LITERAL),
INSPECTION(VERIFICATIONMETHODKIND_INSPECTION_LITERAL),
TEST(VERIFICATIONMETHODKIND_TEST_LITERAL);
        private String text;

       VerificationMethodKindEnum(String text)
        {
            this.text = text;
        }

        public String getText()
        {
            return this.text;
        }
@CheckForNull
        public static VerificationMethodKindEnum from(@CheckForNull Object o) {
  String text = null;
  if(o instanceof EnumerationLiteral)  {
       text = ((EnumerationLiteral)o).getName();
   }
   else if(o != null){text = o.toString();}
            if (text != null) {
                for (VerificationMethodKindEnum b : VerificationMethodKindEnum.values()) {
                    if (text.equals(b.text)) {
                        return b;
                    }
                }
            }
            return null;
        }
}


public static class AbstractRequirement extends AbstractStereotypeWrapper {


//stereotype AbstractRequirement and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "AbstractRequirement";

/**
* Derived from all requirements that are the client of a  deriveReqt  relationship for which this requirement is a supplier.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String DERIVED = "Derived";

/**
* Derived from all requirements that are the supplier of a  deriveReqt  relationship for which this requirement is a client.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String DERIVEDFROM = "DerivedFrom";

/**
* The unique id of the requirement.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String ID = "Id";

/**
* This is a derived property that lists the master requirement for this slave requirement. The master attribute is derived from the supplier of the Copy dependency that has this requirement as the slave.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String MASTER = "Master";

/**
* Derived from all elements that are the client of a  refine  relationship for which this requirement is a supplier.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String REFINEDBY = "RefinedBy";

/**
* Derived from all elements that are the client of a  satisfy  relationship for which this requirement is a supplier.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String SATISFIEDBY = "SatisfiedBy";

/**
* The textual representation or a reference to the textual representation of the requirement.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String TEXT = "Text";

/**
* Derived from all elements that are the client of a  trace  relationship for which this requirement is a supplier.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String TRACEDTO = "TracedTo";

/**
* Derived from all elements that are the client of a  verify  relationship for which this requirement is a supplier.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String VERIFIEDBY = "VerifiedBy";
@SuppressWarnings("UnusedDeclaration")
public static void setDerived(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), DERIVED, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearDerived(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAbstractRequirement(), DERIVED, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addDerived(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), DERIVED, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeDerived(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getDerived(element));
values.remove(value);
setDerived(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getDerived(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), DERIVED));
}

@SuppressWarnings("UnusedDeclaration")
public static void setDerivedFrom(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), DERIVEDFROM, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearDerivedFrom(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAbstractRequirement(), DERIVEDFROM, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addDerivedFrom(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), DERIVEDFROM, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeDerivedFrom(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getDerivedFrom(element));
values.remove(value);
setDerivedFrom(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getDerivedFrom(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), DERIVEDFROM));
}

@SuppressWarnings("UnusedDeclaration")
public static void setId(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), ID, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearId(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAbstractRequirement(), ID, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getId(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getAbstractRequirement(), ID));
}

@SuppressWarnings("UnusedDeclaration")
public static void setMaster(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), MASTER, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearMaster(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAbstractRequirement(), MASTER, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getMaster(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getAbstractRequirement(), MASTER));
}

@SuppressWarnings("UnusedDeclaration")
public static void setRefinedBy(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), REFINEDBY, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearRefinedBy(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAbstractRequirement(), REFINEDBY, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addRefinedBy(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), REFINEDBY, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeRefinedBy(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getRefinedBy(element));
values.remove(value);
setRefinedBy(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getRefinedBy(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), REFINEDBY));
}

@SuppressWarnings("UnusedDeclaration")
public static void setSatisfiedBy(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), SATISFIEDBY, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearSatisfiedBy(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAbstractRequirement(), SATISFIEDBY, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addSatisfiedBy(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), SATISFIEDBY, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeSatisfiedBy(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getSatisfiedBy(element));
values.remove(value);
setSatisfiedBy(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getSatisfiedBy(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), SATISFIEDBY));
}

@SuppressWarnings("UnusedDeclaration")
public static void setText(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), TEXT, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearText(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAbstractRequirement(), TEXT, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getText(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getAbstractRequirement(), TEXT));
}

@SuppressWarnings("UnusedDeclaration")
public static void setTracedTo(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), TRACEDTO, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearTracedTo(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAbstractRequirement(), TRACEDTO, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addTracedTo(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), TRACEDTO, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeTracedTo(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getTracedTo(element));
values.remove(value);
setTracedTo(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getTracedTo(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), TRACEDTO));
}

@SuppressWarnings("UnusedDeclaration")
public static void setVerifiedBy(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), VERIFIEDBY, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearVerifiedBy(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAbstractRequirement(), VERIFIEDBY, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addVerifiedBy(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), VERIFIEDBY, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeVerifiedBy(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getVerifiedBy(element));
values.remove(value);
setVerifiedBy(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getVerifiedBy(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getAbstractRequirement(), VERIFIEDBY));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getAbstractRequirement()
{
return getStereotype(AbstractRequirement.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isAbstractRequirement(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getAbstractRequirement());
}
return false;
}

public static class AcceptChangeStructuralFeatureEventAction extends AbstractStereotypeWrapper {


//stereotype AcceptChangeStructuralFeatureEventAction and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "AcceptChangeStructuralFeatureEventAction";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getAcceptChangeStructuralFeatureEventAction()
{
return getStereotype(AcceptChangeStructuralFeatureEventAction.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isAcceptChangeStructuralFeatureEventAction(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.actions.mdcompleteactions.AcceptEventAction){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getAcceptChangeStructuralFeatureEventAction());
}
return false;
}

public static class Actuator extends AbstractStereotypeWrapper {


//stereotype Actuator and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Actuator";
}


/**
* An Actuator is a special external system that influences the environment of the system under development. For example a Heater assembly or a Central locking system of a car.

*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getActuator()
{
return getStereotype(Actuator.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isActuator(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.mdusecases.Actor){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getActuator());
}
return false;
}

public static class AdjunctProperty extends AbstractStereotypeWrapper {


//stereotype AdjunctProperty and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "AdjunctProperty";

/**
* Gives the element that determines the values of the property.  Must be a connector, call action, object node, variable, or parameter.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String PRINCIPAL = "principal";
@SuppressWarnings("UnusedDeclaration")
public static void setPrincipal(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAdjunctProperty(), PRINCIPAL, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearPrincipal(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAdjunctProperty(), PRINCIPAL, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getPrincipal(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getAdjunctProperty(), PRINCIPAL));
}

}


/**
* The AdjunctProperty stereotype can be applied to properties to constrain their values to the values of connectors typed by association blocks, call actions, object nodes, variables, or parameters, interaction uses, and submachine states.  The values of connectors typed by association blocks are the instances of the association block typing a connector in the block having the stereotyped property.  The values of call actions are the executions of behaviors invoked by the behavior having the call action and the stereotyped property (see Subclause 11.3.1.1.1 for more about this use of the stereotype).  The values of object nodes are the values of tokens in the object nodes of the behavior having the stereotyped property (see Subclause 11.3.1.4.1 for more about this use of the stereotype).  The values of variables are those assigned by executions of activities that have the stereotyped property.  The values of parameters are those assigned by executions of behaviors that have the stereotyped property.  The keyword  adjunct  before a property name indicates the property is stereotyped by AdjunctProperty.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getAdjunctProperty()
{
return getStereotype(AdjunctProperty.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isAdjunctProperty(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getAdjunctProperty());
}
return false;
}

public static class Allocate extends AbstractStereotypeWrapper {


//stereotype Allocate and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Allocate";
}


/**
* Allocate is a dependency based on UML::abstraction. It is a mechanism for associating elements of different types, or in different hierarchies, at an abstract level. Allocate is used for assessing user model consistency and directing future design activity. It is expected that an  allocate  relationship between model elements is a precursor to a more concrete relationship between the elements, their properties, operations, attributes, or sub-classes.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getAllocate()
{
return getStereotype(Allocate.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isAllocate(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getAllocate());
}
return false;
}

public static class AllocateActivityPartition extends AbstractStereotypeWrapper {


//stereotype AllocateActivityPartition and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "AllocateActivityPartition";
}


/**
* AllocateActivityPartition is used to depict an  allocate  relationship on an Activity diagram. The AllocateActivityPartition is a standard UML2::ActivityPartition, with modified constraints as stated in the paragraph below.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getAllocateActivityPartition()
{
return getStereotype(AllocateActivityPartition.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isAllocateActivityPartition(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdintermediateactivities.ActivityPartition){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getAllocateActivityPartition());
}
return false;
}

public static class Allocated extends AbstractStereotypeWrapper {


//stereotype Allocated and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Allocated";

/**
* Reverse of allocatedTo: the element types and names of the set of elements that are clients (from) of an  allocate  whose supplier is extended by this stereotype (instance). The same characteristics apply as to /allocatedTo. Each allocatedFrom property will be expressed as  elementType  ElementName.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String ALLOCATEDFROM = "allocatedFrom";

/**
* The element types and names of the set of elements that are suppliers ( to  end of the concrete syntax) of an  allocate  whose client is extended by this stereotype (instance). This property is the union of all suppliers to which this instance is the client, i.e., there may be more than one /allocatedTo property per allocated model element. Each allocatedTo property will be expressed as  elementType  ElementName.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String ALLOCATEDTO = "allocatedTo";
@SuppressWarnings("UnusedDeclaration")
public static void setAllocatedFrom(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAllocated(), ALLOCATEDFROM, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearAllocatedFrom(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAllocated(), ALLOCATEDFROM, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addAllocatedFrom(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAllocated(), ALLOCATEDFROM, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeAllocatedFrom(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getAllocatedFrom(element));
values.remove(value);
setAllocatedFrom(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getAllocatedFrom(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getAllocated(), ALLOCATEDFROM));
}

@SuppressWarnings("UnusedDeclaration")
public static void setAllocatedTo(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAllocated(), ALLOCATEDTO, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearAllocatedTo(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getAllocated(), ALLOCATEDTO, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addAllocatedTo(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getAllocated(), ALLOCATEDTO, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeAllocatedTo(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getAllocatedTo(element));
values.remove(value);
setAllocatedTo(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getAllocatedTo(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getAllocated(), ALLOCATEDTO));
}

}


/**
*  allocated  is a stereotype that applies to any NamedElement that has at least one allocation relationship with another NamedElement.  allocated  elements may be designated by either the /from or /to end of an  allocate  dependency. The  allocated  stereotype provides a mechanism for a particular model element to conveniently retain and display the element at the opposite end of any  allocate  dependency. This stereotype provides for the properties  allocatedFrom  and  allocatedTo,  which are derived from the  allocate  dependency.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getAllocated()
{
return getStereotype(Allocated.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isAllocated(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getAllocated());
}
return false;
}

public static class BasicInterval extends AbstractStereotypeWrapper {


//stereotype BasicInterval and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "BasicInterval";
@SuppressWarnings("UnusedDeclaration")
public static final String MAX = "max";
@SuppressWarnings("UnusedDeclaration")
public static final String MIN = "min";
@SuppressWarnings("UnusedDeclaration")
public static void setMax(Element element, Object value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getBasicInterval(), MAX, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearMax(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getBasicInterval(), MAX, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Object getMax(Element element){
return (Object)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getBasicInterval(), MAX));
}

@SuppressWarnings("UnusedDeclaration")
public static void setMin(Element element, Object value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getBasicInterval(), MIN, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearMin(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getBasicInterval(), MIN, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Object getMin(Element element){
return (Object)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getBasicInterval(), MIN));
}

}


/**
* Basic Interval distribution - value between min and max inclusive
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getBasicInterval()
{
return getStereotype(BasicInterval.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isBasicInterval(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getBasicInterval());
}
return false;
}

public static class BindingConnector extends AbstractStereotypeWrapper {


//stereotype BindingConnector and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "BindingConnector";
}


/**
* A Binding Connector is a connector which specifies that the properties at both ends of the connector have equal values. If the properties at the ends of a binding connector are typed by a DataType or ValueType, the connector specifies that the instances of the properties must hold equal values, recursively through any nested properties within the connected properties. If the properties at the ends of a binding connector are typed by a Block, the connector specifies that the instances of the properties must refer to the same block instance. As with any connector owned by a SysML Block, the ends of a binding connector may be nested within a multi-level path of properties accessible from the owning block. The NestedConnectorEnd stereotype is used to represent such nested ends just as for nested ends of other SysML connectors.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getBindingConnector()
{
return getStereotype(BindingConnector.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isBindingConnector(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getBindingConnector());
}
return false;
}

public static class Block extends AbstractStereotypeWrapper {


//stereotype Block and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Block";

/**
* If true, then the block is treated as a black box; a part typed by this black box can only be connected via its ports or directly to its outer boundary. If false, or if a value is not present, then connections can be established to elements of its internal structure via deep-nested connector ends.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String ISENCAPSULATED = "isEncapsulated";
@SuppressWarnings("UnusedDeclaration")
public static void setIsEncapsulated(Element element, Boolean value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getBlock(), ISENCAPSULATED, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearIsEncapsulated(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getBlock(), ISENCAPSULATED, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Boolean isIsEncapsulated(Element element){
return toBoolean(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getBlock(), ISENCAPSULATED));
}

}


/**
* A Block is a modular unit that describes the structure of a system or element. It may include both structural and behavioral features, such as properties and operations, that represent the state of the system and behavior that the system may exhibit. Some of these properties may hold parts of a system, which can also be described by blocks. A block may include a structure of connectors between its properties to indicate how its parts or other properties relate to one another. SysML blocks provide a general-purpose capability to describe the architecture of a system. They provide the ability to represent a system hierarchy, in which a system at one level is composed of systems at a more basic level. They can describe not only the connectivity relationships between the systems at any level, but also quantitative values or other information about a system. SysML does not restrict the kind of system or system element that may be described by a block. Any reusable form of description that may be applied to a system or a set of system characteristics may be described by a block. Such reusable descriptions, for example, may be applied to purely conceptual aspects of a system design, such as relationships that hold between parts or properties of a system. Connectors owned by SysML blocks may be used to define relationships between parts or other properties of the same containing block. The type of a connector or its connected ends may specify the semantic interpretation of a specific connector.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getBlock()
{
return getStereotype(Block.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isBlock(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getBlock());
}
return false;
}

public static class BlockHierarchy extends AbstractStereotypeWrapper {


//stereotype BlockHierarchy and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "BlockHierarchy";
}


/**
* Block definition diagram usage for a block hierarchy - Block Hierarchy where block can be replaced by system, item, activity, etc.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getBlockHierarchy()
{
return getStereotype(BlockHierarchy.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isBlockHierarchy(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Diagram){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getBlockHierarchy());
}
return false;
}

public static class BoundReference extends AbstractStereotypeWrapper {


//stereotype BoundReference and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "BoundReference";

/**
* Gives the propertyPath of the NestedConnectorEnd applied, if any, to the boundEnd, appended to the role of the boundEnd. 
*/
@SuppressWarnings("UnusedDeclaration")
public static final String BINDINGPATH = "bindingPath";

/**
* Gives a connector end of a binding connector opposite to the end linked to the stereotyped property, or linked to a property that generalizes the stereotyped one through redefinition.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String BOUNDEND = "boundEnd";
@SuppressWarnings("UnusedDeclaration")
public static void setBindingPath(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getBoundReference(), BINDINGPATH, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearBindingPath(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getBoundReference(), BINDINGPATH, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addBindingPath(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getBoundReference(), BINDINGPATH, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeBindingPath(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getBindingPath(element));
values.remove(value);
setBindingPath(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getBindingPath(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getBoundReference(), BINDINGPATH));
}

@SuppressWarnings("UnusedDeclaration")
public static void setBoundEnd(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getBoundReference(), BOUNDEND, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearBoundEnd(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getBoundReference(), BOUNDEND, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getBoundEnd(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getBoundReference(), BOUNDEND));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getBoundReference()
{
return getStereotype(BoundReference.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isBoundReference(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getBoundReference());
}
return false;
}

public static class Boundarysystem extends AbstractStereotypeWrapper {


//stereotype Boundary system and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Boundary system";
}


/**
* A Boundary system is a special external system that serves as medium between another system and the system under development without having own interests in the communication. For example Bus system or Communication system.

*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getBoundarysystem()
{
return getStereotype(Boundarysystem.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isBoundarysystem(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.mdusecases.Actor){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getBoundarysystem());
}
return false;
}

public static class ChangeStructuralFeatureEvent extends AbstractStereotypeWrapper {


//stereotype ChangeStructuralFeatureEvent and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ChangeStructuralFeatureEvent";
@SuppressWarnings("UnusedDeclaration")
public static final String STRUCTURALFEATURE = "structuralFeature";
@SuppressWarnings("UnusedDeclaration")
public static void setStructuralFeature(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getChangeStructuralFeatureEvent(), STRUCTURALFEATURE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearStructuralFeature(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getChangeStructuralFeatureEvent(), STRUCTURALFEATURE, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getStructuralFeature(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getChangeStructuralFeatureEvent(), STRUCTURALFEATURE));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getChangeStructuralFeatureEvent()
{
return getStereotype(ChangeStructuralFeatureEvent.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isChangeStructuralFeatureEvent(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.ChangeEvent){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getChangeStructuralFeatureEvent());
}
return false;
}

public static class ClassifierBehaviorProperty extends AbstractStereotypeWrapper {


//stereotype ClassifierBehaviorProperty and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ClassifierBehaviorProperty";
}


/**
* The ClassifierBehaviorProperty stereotype can be applied to properties to constrain their values to be the executions of classifier behaviors.  The value of properties with ClassifierBehaviorProperty  applied are the executions of classifier behaviors invoked by instantiation of the block that owns the stereotyped property or one of its specializations.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getClassifierBehaviorProperty()
{
return getStereotype(ClassifierBehaviorProperty.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isClassifierBehaviorProperty(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getClassifierBehaviorProperty());
}
return false;
}

public static class Conform extends AbstractStereotypeWrapper {


//stereotype Conform and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Conform";
}


/**
* A Conform relationship is a dependency between a view and a viewpoint. The view conforms to the specified rules and conventions detailed in the viewpoint. Conform is a specialization of the UML dependency, and as with other dependencies the arrow direction points from the (client/source) to the (supplier/target).
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getConform()
{
return getStereotype(Conform.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isConform(@CheckForNull Element element)
{
if((element instanceof com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency
|| element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Generalization)){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getConform());
}
return false;
}

public static class ConnectorProperty extends AbstractStereotypeWrapper {


//stereotype ConnectorProperty and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ConnectorProperty";

/**
* A connector of the block owning the property on which the stereotype is applied.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String CONNECTOR = "connector";
@SuppressWarnings("UnusedDeclaration")
public static void setConnector(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getConnectorProperty(), CONNECTOR, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearConnector(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getConnectorProperty(), CONNECTOR, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getConnector(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getConnectorProperty(), CONNECTOR));
}

}


/**
* Connectors can be typed by association classes that are stereotyped by Block (association blocks). These connectors specify instances (links) of the association block that exist due to instantiation of the block owning or inheriting the connector. The value of a connector property on an instance of a block will be exactly those link objects that are instances of the association block typing the connector referred to by the connector property.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getConnectorProperty()
{
return getStereotype(ConnectorProperty.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isConnectorProperty(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getConnectorProperty());
}
return false;
}

public static class ConstraintBlock extends AbstractStereotypeWrapper {


//stereotype ConstraintBlock and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ConstraintBlock";
}


/**
* A constraint block is a block that packages the statement of a constraint so it may be applied in a reusable way to constrain properties of other blocks. A constraint block typically defines one or more constraint parameters, which are bound to properties of other blocks in a surrounding context where the constraint is used. Binding connectors, as defined in Chapter 8: Blocks, are used to bind each parameter of the constraint block to a property in the surrounding context. All properties of a constraint block are constraint parameters, with the exception of constraint properties that hold internally nested usages of other constraint blocks.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getConstraintBlock()
{
return getStereotype(ConstraintBlock.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isConstraintBlock(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getConstraintBlock());
}
return false;
}

public static class ContextDiagram extends AbstractStereotypeWrapper {


//stereotype ContextDiagram and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ContextDiagram";
}


/**
* A user defined usage of an internal block diagram, which depicts some of the top level entities in the overall enterprise and their relationships.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getContextDiagram()
{
return getStereotype(ContextDiagram.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isContextDiagram(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Diagram){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getContextDiagram());
}
return false;
}

public static class Continuous extends AbstractStereotypeWrapper {


//stereotype Continuous and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Continuous";
}


/**
* Continuous rate is a special case of rate of flow (see Rate) where the increment of time between items approaches zero. It is intended to represent continuous flows that may correspond to water flowing through a pipe, a time continuous signal, or continuous energy flow. It is independent from UML streaming. A streaming parameter may or may not apply to continuous flow, and a continuous flow may or may not apply to streaming parameters.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getContinuous()
{
return getStereotype(Continuous.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isContinuous(@CheckForNull Element element)
{
if((element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ActivityEdge
|| element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ObjectNode
|| element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Parameter)){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getContinuous());
}
return false;
}

public static class ControlOperator extends AbstractStereotypeWrapper {


//stereotype ControlOperator and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ControlOperator";
}


/**
* A control operator is a behavior that is intended to represent an arbitrarily complex logical operator that can be used to enable and disable other actions. When this stereotype is applied to behaviors, the behavior takes control values as inputs or provides them as outputs, that is, it treats control as data. When this stereotype is not applied, the behavior may not have a parameter typed by ControlValue. This stereotype also applies to operations with the same semantics.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getControlOperator()
{
return getStereotype(ControlOperator.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isControlOperator(@CheckForNull Element element)
{
if((element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Operation
|| element instanceof com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior)){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getControlOperator());
}
return false;
}

public static class Copy extends AbstractStereotypeWrapper {


//stereotype Copy and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Copy";
}


/**
* A Copy relationship is a dependency between a supplier requirement and a client requirement that specifies that the text of the client requirement is a read-only copy of the text of the supplier requirement.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getCopy()
{
return getStereotype(Copy.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isCopy(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getCopy());
}
return false;
}

public static class DeriveReqt extends AbstractStereotypeWrapper {


//stereotype DeriveReqt and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "DeriveReqt";
}


/**
* A DeriveReqt relationship is a dependency between two requirements in which a client requirement can be derived from the supplier requirement. As with other dependencies, the arrow direction points from the derived (client) requirement to the (supplier) requirement from which it is derived.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getDeriveReqt()
{
return getStereotype(DeriveReqt.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isDeriveReqt(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getDeriveReqt());
}
return false;
}

public static class DiagramDescription extends AbstractStereotypeWrapper {


//stereotype Diagram Description and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Diagram Description";
@SuppressWarnings("UnusedDeclaration")
public static final String COMPLETION_STATUS = "Completion status";
@SuppressWarnings("UnusedDeclaration")
public static final String DESCRIPTION = "Description";
@SuppressWarnings("UnusedDeclaration")
public static final String REFERENCE = "Reference";
@SuppressWarnings("UnusedDeclaration")
public static final String VERSION = "Version";
@SuppressWarnings("UnusedDeclaration")
public static void setCompletionstatus(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDiagramDescription(), COMPLETION_STATUS, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearCompletionstatus(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getDiagramDescription(), COMPLETION_STATUS, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getCompletionstatus(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getDiagramDescription(), COMPLETION_STATUS));
}

@SuppressWarnings("UnusedDeclaration")
public static void setDescription(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDiagramDescription(), DESCRIPTION, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearDescription(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getDiagramDescription(), DESCRIPTION, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getDescription(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getDiagramDescription(), DESCRIPTION));
}

@SuppressWarnings("UnusedDeclaration")
public static void setReference(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDiagramDescription(), REFERENCE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearReference(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getDiagramDescription(), REFERENCE, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getReference(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getDiagramDescription(), REFERENCE));
}

@SuppressWarnings("UnusedDeclaration")
public static void setVersion(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDiagramDescription(), VERSION, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearVersion(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getDiagramDescription(), VERSION, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getVersion(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getDiagramDescription(), VERSION));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getDiagramDescription()
{
return getStereotype(DiagramDescription.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isDiagramDescription(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Diagram){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getDiagramDescription());
}
return false;
}

public static class DirectedFeature extends AbstractStereotypeWrapper {


//stereotype DirectedFeature and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "DirectedFeature";
@SuppressWarnings("UnusedDeclaration")
public static final String FEATUREDIRECTION = "featureDirection";
@SuppressWarnings("UnusedDeclaration")
public static void setFeatureDirection(Element element, FeatureDirectionEnum value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDirectedFeature(), FEATUREDIRECTION, value != null ? value.getText() : null);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearFeatureDirection(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getDirectedFeature(), FEATUREDIRECTION, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static FeatureDirectionEnum getFeatureDirection(Element element){
return FeatureDirectionEnum.from(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getDirectedFeature(), FEATUREDIRECTION));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getDirectedFeature()
{
return getStereotype(DirectedFeature.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isDirectedFeature(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Feature){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getDirectedFeature());
}
return false;
}

public static class DirectedRelationshipPropertyPath extends AbstractStereotypeWrapper {


//stereotype DirectedRelationshipPropertyPath and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "DirectedRelationshipPropertyPath";

/**
* Gives the context for sourcePropertyPath to begin from.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String SOURCECONTEXT = "sourceContext";

/**
* A series of properties that identifies the source of the directed relationship in the context of the block specified by the sourceContext property.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String SOURCEPROPERTYPATH = "sourcePropertyPath";

/**
* Gives the context for targetPropertyPath to begin from.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String TARGETCONTEXT = "targetContext";

/**
* A series of properties that identifies the target of the directed relationship in the context of the block specified by the targetContext property. 
*/
@SuppressWarnings("UnusedDeclaration")
public static final String TARGETPROPERTYPATH = "targetPropertyPath";
@SuppressWarnings("UnusedDeclaration")
public static void setSourceContext(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDirectedRelationshipPropertyPath(), SOURCECONTEXT, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearSourceContext(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getDirectedRelationshipPropertyPath(), SOURCECONTEXT, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getSourceContext(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getDirectedRelationshipPropertyPath(), SOURCECONTEXT));
}

@SuppressWarnings("UnusedDeclaration")
public static void setSourcePropertyPath(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDirectedRelationshipPropertyPath(), SOURCEPROPERTYPATH, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearSourcePropertyPath(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getDirectedRelationshipPropertyPath(), SOURCEPROPERTYPATH, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addSourcePropertyPath(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDirectedRelationshipPropertyPath(), SOURCEPROPERTYPATH, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeSourcePropertyPath(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getSourcePropertyPath(element));
values.remove(value);
setSourcePropertyPath(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getSourcePropertyPath(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getDirectedRelationshipPropertyPath(), SOURCEPROPERTYPATH));
}

@SuppressWarnings("UnusedDeclaration")
public static void setTargetContext(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDirectedRelationshipPropertyPath(), TARGETCONTEXT, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearTargetContext(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getDirectedRelationshipPropertyPath(), TARGETCONTEXT, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getTargetContext(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getDirectedRelationshipPropertyPath(), TARGETCONTEXT));
}

@SuppressWarnings("UnusedDeclaration")
public static void setTargetPropertyPath(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDirectedRelationshipPropertyPath(), TARGETPROPERTYPATH, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearTargetPropertyPath(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getDirectedRelationshipPropertyPath(), TARGETPROPERTYPATH, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addTargetPropertyPath(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getDirectedRelationshipPropertyPath(), TARGETPROPERTYPATH, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeTargetPropertyPath(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getTargetPropertyPath(element));
values.remove(value);
setTargetPropertyPath(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getTargetPropertyPath(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getDirectedRelationshipPropertyPath(), TARGETPROPERTYPATH));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getDirectedRelationshipPropertyPath()
{
return getStereotype(DirectedRelationshipPropertyPath.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isDirectedRelationshipPropertyPath(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.DirectedRelationship){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getDirectedRelationshipPropertyPath());
}
return false;
}

public static class Discrete extends AbstractStereotypeWrapper {


//stereotype Discrete and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Discrete";
}


/**
* Discrete rate is a special case of rate of flow (see Rate) where the increment of time between items is non-zero.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getDiscrete()
{
return getStereotype(Discrete.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isDiscrete(@CheckForNull Element element)
{
if((element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ActivityEdge
|| element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ObjectNode
|| element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Parameter)){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getDiscrete());
}
return false;
}

public static class DistributedProperty extends AbstractStereotypeWrapper {


//stereotype DistributedProperty and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "DistributedProperty";
}


/**
* DistributedProperty is a stereotype of Property used to apply a probability distribution to the values of the property. Specific distributions should be defined as subclasses of the DistributedProperty stereotype with the operands of the distributions represented by properties of those stereotype subclasses.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getDistributedProperty()
{
return getStereotype(DistributedProperty.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isDistributedProperty(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getDistributedProperty());
}
return false;
}

public static class Domain extends AbstractStereotypeWrapper {


//stereotype Domain and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Domain";
}


/**
* A Domain block represents an entity, a concept, a location, or a person from the real-world domain. A domain block is part of the system knowledge.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getDomain()
{
return getStereotype(Domain.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isDomain(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getDomain());
}
return false;
}

public static class ElementGroup extends AbstractStereotypeWrapper {


//stereotype ElementGroup and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ElementGroup";

/**
* Specifies the rationale for being member of the group. Adding an element to the group asserts that the criterion
applies to this element.
Derived from Comment::body.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String CRITERION = "criterion";

/**
* Set specifying the members of the group.
Derived from Comment::annotatedElement.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String MEMBER = "member";
@SuppressWarnings("UnusedDeclaration")
public static final String NAME = "name";

/**
* Organize member according to an arbitrary order. Optional.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String ORDEREDMEMBER = "orderedMember";

/**
* Number of members in the group. Derived.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String SIZE = "size";
@SuppressWarnings("UnusedDeclaration")
public static void setCriterion(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getElementGroup(), CRITERION, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearCriterion(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getElementGroup(), CRITERION, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getCriterion(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getElementGroup(), CRITERION));
}

@SuppressWarnings("UnusedDeclaration")
public static void setMember(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getElementGroup(), MEMBER, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearMember(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getElementGroup(), MEMBER, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addMember(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getElementGroup(), MEMBER, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeMember(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getMember(element));
values.remove(value);
setMember(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getMember(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getElementGroup(), MEMBER));
}

@SuppressWarnings("UnusedDeclaration")
public static void setName(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getElementGroup(), NAME, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearName(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getElementGroup(), NAME, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getName(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getElementGroup(), NAME));
}

@SuppressWarnings("UnusedDeclaration")
public static void setOrderedMember(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getElementGroup(), ORDEREDMEMBER, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearOrderedMember(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getElementGroup(), ORDEREDMEMBER, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addOrderedMember(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getElementGroup(), ORDEREDMEMBER, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeOrderedMember(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getOrderedMember(element));
values.remove(value);
setOrderedMember(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getOrderedMember(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getElementGroup(), ORDEREDMEMBER));
}

@SuppressWarnings("UnusedDeclaration")
public static void setSize(Element element, Integer value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getElementGroup(), SIZE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearSize(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getElementGroup(), SIZE, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Integer getSize(Element element){
return toInteger(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getElementGroup(), SIZE));
}

}


/**
* The ElementGroup stereotype provides a lightweight mechanism for grouping various and possibly heterogeneous model elements by extending the capability of comments to refer to multiple annotated elements. For example, it can group elements that are associated with a particular release of the model, have a certain risk level, or are associated with a legacy design.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getElementGroup()
{
return getStereotype(ElementGroup.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isElementGroup(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Comment){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getElementGroup());
}
return false;
}

public static class ElementPropertyPath extends AbstractStereotypeWrapper {


//stereotype ElementPropertyPath and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ElementPropertyPath";

/**
* The propertyPath list of the NestedConnectorEnd stereotype must identify a path of containing properties that identify the connected property in the context of the block that owns the connector. The ordering of properties is from a property of the block that owns the connector, through a property of each intermediate block that types the preceding property, until a property is reached that contains a connector end property within its type. The connector end property is not included in the propertyPath list, but instead is held by the role property of the UML ConnectorEnd metaclass.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String PROPERTYPATH = "propertyPath";
@SuppressWarnings("UnusedDeclaration")
public static void setPropertyPath(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getElementPropertyPath(), PROPERTYPATH, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearPropertyPath(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getElementPropertyPath(), PROPERTYPATH, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addPropertyPath(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getElementPropertyPath(), PROPERTYPATH, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removePropertyPath(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getPropertyPath(element));
values.remove(value);
setPropertyPath(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getPropertyPath(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getElementPropertyPath(), PROPERTYPATH));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getElementPropertyPath()
{
return getStereotype(ElementPropertyPath.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isElementPropertyPath(@CheckForNull Element element)
{
if(element !=null){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getElementPropertyPath());
}
return false;
}

public static class EndPathMultiplicity extends AbstractStereotypeWrapper {


//stereotype EndPathMultiplicity and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "EndPathMultiplicity";

/**
* Gives the minimum number of values of the property at the end of the related bindingPath, for each object reached by navigation along the bindingPath from an instance of the block owning the property to which EndPathMultiplicity is applied
*/
@SuppressWarnings("UnusedDeclaration")
public static final String LOWER = "lower";

/**
* Gives the maximum number of values of the property at the end of the related bindingPath, for each object reached by navigation along the bindingPath from an instance of the block owning the property to which EndPathMultiplicity is applied.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String UPPER = "upper";
@SuppressWarnings("UnusedDeclaration")
public static void setLower(Element element, Integer value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getEndPathMultiplicity(), LOWER, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearLower(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getEndPathMultiplicity(), LOWER, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Integer getLower(Element element){
return toInteger(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getEndPathMultiplicity(), LOWER));
}

@SuppressWarnings("UnusedDeclaration")
public static void setUpper(Element element, Integer value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getEndPathMultiplicity(), UPPER, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearUpper(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getEndPathMultiplicity(), UPPER, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Integer getUpper(Element element){
return toInteger(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getEndPathMultiplicity(), UPPER));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getEndPathMultiplicity()
{
return getStereotype(EndPathMultiplicity.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isEndPathMultiplicity(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getEndPathMultiplicity());
}
return false;
}

public static class Environmentaleffect extends AbstractStereotypeWrapper {


//stereotype Environmental effect and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Environmental effect";
}


/**
* An Environmental effect is an influence on the system from the environment without communicating with it directly. For example Temperature or Humidity.

*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getEnvironmentaleffect()
{
return getStereotype(Environmentaleffect.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isEnvironmentaleffect(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.mdusecases.Actor){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getEnvironmentaleffect());
}
return false;
}

public static class Essential extends AbstractStereotypeWrapper {


//stereotype Essential and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Essential";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getEssential()
{
return getStereotype(Essential.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isEssential(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getEssential());
}
return false;
}

public static class Expose extends AbstractStereotypeWrapper {


//stereotype Expose and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Expose";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getExpose()
{
return getStereotype(Expose.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isExpose(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getExpose());
}
return false;
}

public static class External extends AbstractStereotypeWrapper {


//stereotype External and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "External";
}


/**
* An External block is a block that represents an actor. It facilitates a more detailed modeling of actors like ports or internal structure.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getExternal()
{
return getStereotype(External.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isExternal(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getExternal());
}
return false;
}

public static class Externalsystem extends AbstractStereotypeWrapper {


//stereotype External system and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "External system";
}


/**
* An External system is a system that interacts with the system under development. For example an Information server or a Monitoring system.

*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getExternalsystem()
{
return getStereotype(Externalsystem.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isExternalsystem(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.mdusecases.Actor){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getExternalsystem());
}
return false;
}

public static class FlowPort extends AbstractStereotypeWrapper {


//stereotype FlowPort and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "FlowPort";

/**
* Indicates the direction in which an atomic flow port relays its items. If the direction is set to  in,  then the items are relayed from an external connector via the flow port into the flow port s owner (or one of its parts). If the direction is set to  out,  then the items are relayed from the flow port s owner, via the flow port, through an external connector attached to the flow port. If the direction is set to  inout,  then items can flow both ways. By default, the value is inout.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String DIRECTION = "direction";

/**
* This is a derived attribute (derived from the flow port s type). For a flow port typed by a flow specification the value of this attribute is False, otherwise the value is True.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String ISATOMIC = "isAtomic";
@SuppressWarnings("UnusedDeclaration")
public static void setDirection(Element element, FlowDirectionEnum value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getFlowPort(), DIRECTION, value != null ? value.getText() : null);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearDirection(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getFlowPort(), DIRECTION, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static FlowDirectionEnum getDirection(Element element){
return FlowDirectionEnum.from(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getFlowPort(), DIRECTION));
}

@SuppressWarnings("UnusedDeclaration")
public static void setIsAtomic(Element element, Boolean value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getFlowPort(), ISATOMIC, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearIsAtomic(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getFlowPort(), ISATOMIC, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Boolean isIsAtomic(Element element){
return toBoolean(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getFlowPort(), ISATOMIC));
}

}


/**
* A FlowPort is an interaction point through which input and/or output of items such as data, material, or energy may flow. This enables the owning block to declare which items it may exchange with its environment and the interaction points through which the exchange is made. We distinguish between atomic flow port and a nonatomic flow port. Atomic flow ports relay items that are classified by a single Block, ValueType, DataType, or Signal classifier. A nonatomic flow port relays items of several types as specified by a FlowSpecification. Flow ports and associated flow specifications define  what can flow  between the block and its environment, whereas item flows specify  what does flow  in a specific usage context. Flow ports relay items to their owning block or to a connector that connects them with their owner s internal parts (internal connector).
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getFlowPort()
{
return getStereotype(FlowPort.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isFlowPort(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getFlowPort());
}
return false;
}

public static class FlowProperty extends AbstractStereotypeWrapper {


//stereotype FlowProperty and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "FlowProperty";

/**
* Specifies if the property value is received from an external block (direction= in ), transmitted to an external Block (direction= out ) or both (direction= inout ).
*/
@SuppressWarnings("UnusedDeclaration")
public static final String DIRECTION = "direction";
@SuppressWarnings("UnusedDeclaration")
public static void setDirection(Element element, FlowDirectionEnum value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getFlowProperty(), DIRECTION, value != null ? value.getText() : null);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearDirection(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getFlowProperty(), DIRECTION, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static FlowDirectionEnum getDirection(Element element){
return FlowDirectionEnum.from(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getFlowProperty(), DIRECTION));
}

}


/**
* A FlowProperty signifies a single flow element that can flow to/from a block. A flow property s values are either received from or transmitted to an external block. Flow properties are defined directly on blocks or flow specifications that are those specifications which type the flow ports. Flow properties enable item flows across connectors connecting parts of the corresponding block types, either directly (in case of the property is defined on the block) or via flowPorts. For Block, Data Type, and Value Type properties, setting an  out  FlowProperty value of a block usage on one end of a connector will result in assigning the same value of an  in  FlowProperty of a block usage at the other end of the connector, provided the flow properties are matched. Flow properties of type Signal imply sending and/or receiving of a signal usage. An  out  FlowProperty of type Signal means that the owning Block may broadcast the signal via connectors and an  in  FlowProperty means that the owning block is able to receive the Signal.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getFlowProperty()
{
return getStereotype(FlowProperty.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isFlowProperty(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getFlowProperty());
}
return false;
}

public static class FlowSpecification extends AbstractStereotypeWrapper {


//stereotype FlowSpecification and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "FlowSpecification";
}


/**
* A FlowSpecification specifies inputs and outputs as a set of flow properties. A flow specification is used by flow ports to specify what items can flow via the port.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getFlowSpecification()
{
return getStereotype(FlowSpecification.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isFlowSpecification(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getFlowSpecification());
}
return false;
}

public static class FullPort extends AbstractStereotypeWrapper {


//stereotype FullPort and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "FullPort";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getFullPort()
{
return getStereotype(FullPort.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isFullPort(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getFullPort());
}
return false;
}

public static class InterfaceBlock extends AbstractStereotypeWrapper {


//stereotype InterfaceBlock and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "InterfaceBlock";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getInterfaceBlock()
{
return getStereotype(InterfaceBlock.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isInterfaceBlock(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getInterfaceBlock());
}
return false;
}

public static class Interval extends AbstractStereotypeWrapper {


//stereotype Interval and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Interval";
}


/**
* Interval distribution - unknown probability between min and max
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getInterval()
{
return getStereotype(Interval.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isInterval(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getInterval());
}
return false;
}

public static class InvocationOnNestedPortAction extends AbstractStereotypeWrapper {


//stereotype InvocationOnNestedPortAction and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "InvocationOnNestedPortAction";
@SuppressWarnings("UnusedDeclaration")
public static final String ONNESTEDPORT = "onNestedPort";
@SuppressWarnings("UnusedDeclaration")
public static void setOnNestedPort(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getInvocationOnNestedPortAction(), ONNESTEDPORT, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearOnNestedPort(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getInvocationOnNestedPortAction(), ONNESTEDPORT, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addOnNestedPort(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getInvocationOnNestedPortAction(), ONNESTEDPORT, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeOnNestedPort(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getOnNestedPort(element));
values.remove(value);
setOnNestedPort(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getOnNestedPort(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getInvocationOnNestedPortAction(), ONNESTEDPORT));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getInvocationOnNestedPortAction()
{
return getStereotype(InvocationOnNestedPortAction.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isInvocationOnNestedPortAction(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.actions.mdbasicactions.InvocationAction){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getInvocationOnNestedPortAction());
}
return false;
}

public static class ItemFlow extends AbstractStereotypeWrapper {


//stereotype ItemFlow and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ItemFlow";

/**
* An optional property that relates the flowing item to the instances of the connector s enclosing block. This property is applicable only for item flows assigned to connectors. The multiplicity is zero if the item flow is assigned to an Association.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String ITEMPROPERTY = "itemProperty";
@SuppressWarnings("UnusedDeclaration")
public static void setItemProperty(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getItemFlow(), ITEMPROPERTY, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearItemProperty(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getItemFlow(), ITEMPROPERTY, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getItemProperty(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getItemFlow(), ITEMPROPERTY));
}

}


/**
* An ItemFlow describes the flow of items across a connector or an association. It may constrain the item exchange between blocks, block usages, or flow ports as specified by their flow properties. For example, a pump connected to a tank: the pump has an  out  flow property of type Liquid and the tank has an  in  FlowProperty of type Liquid. To signify that only water flows between the pump and the tank, we can specify an ItemFlow of type Water on the connector.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getItemFlow()
{
return getStereotype(ItemFlow.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isItemFlow(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.auxiliaryconstructs.mdinformationflows.InformationFlow){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getItemFlow());
}
return false;
}

public static class NestedConnectorEnd extends AbstractStereotypeWrapper {


//stereotype NestedConnectorEnd and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "NestedConnectorEnd";
}


/**
* The NestedConnectorEnd stereotype of UML ConnectorEnd extends a UML ConnectorEnd so that the connected property may be identified by a multi-level path of accessible properties from the block that owns the connector.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getNestedConnectorEnd()
{
return getStereotype(NestedConnectorEnd.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isNestedConnectorEnd(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.ConnectorEnd){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getNestedConnectorEnd());
}
return false;
}

public static class NoBuffer extends AbstractStereotypeWrapper {


//stereotype NoBuffer and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "NoBuffer";
}


/**
* When this stereotype is applied to object nodes, tokens arriving at the node are discarded if they are refused by outgoing edges, or refused by actions for object nodes that are input pins. This is typically used with fast or continuously flowing data values, to prevent buffer overrun, or to model transient values, such as electrical signals. For object nodes that are the target of continuous flows,  nobuffer  and  overwrite  have the same effect. The stereotype does not override UML token offering semantics; it just indicates what happens to the token when it is accepted. When the stereotype is not applied, the semantics are as in UML, specifically, tokens arriving at an object node that are refused by outgoing edges, or action for input pins, are held until they can leave the object node.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getNoBuffer()
{
return getStereotype(NoBuffer.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isNoBuffer(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ObjectNode){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getNoBuffer());
}
return false;
}

public static class Normal extends AbstractStereotypeWrapper {


//stereotype Normal and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Normal";
@SuppressWarnings("UnusedDeclaration")
public static final String MEAN = "mean";
@SuppressWarnings("UnusedDeclaration")
public static final String STANDARDDEVIATION = "standardDeviation";
@SuppressWarnings("UnusedDeclaration")
public static void setMean(Element element, Object value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getNormal(), MEAN, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearMean(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getNormal(), MEAN, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Object getMean(Element element){
return (Object)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getNormal(), MEAN));
}

@SuppressWarnings("UnusedDeclaration")
public static void setStandardDeviation(Element element, Object value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getNormal(), STANDARDDEVIATION, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearStandardDeviation(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getNormal(), STANDARDDEVIATION, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Object getStandardDeviation(Element element){
return (Object)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getNormal(), STANDARDDEVIATION));
}

}


/**
* Normal distribution - constant probability between min and max
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getNormal()
{
return getStereotype(Normal.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isNormal(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getNormal());
}
return false;
}

public static class Optional extends AbstractStereotypeWrapper {


//stereotype Optional and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Optional";
}


/**
* When the  optional  stereotype is applied to parameters, the lower multiplicity must be equal to zero. This means the parameter is not required to have a value for the activity or any behavior to begin or end execution. Otherwise, the lower multiplicity must be greater than zero, which is called  required. 
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getOptional()
{
return getStereotype(Optional.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isOptional(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Parameter){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getOptional());
}
return false;
}

public static class Overwrite extends AbstractStereotypeWrapper {


//stereotype Overwrite and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Overwrite";
}


/**
* When the  overwrite  stereotype is applied to object nodes, a token arriving at a full object node replaces the ones already there (a full object node has as many tokens as allowed by its upper bound). This is typically used on an input pin with an upper bound of 1 to ensure that stale data is overridden at an input pin. For upper bounds greater than one, the token replaced is the one that would be the last to be selected according to the ordering kind for the node. For FIFO ordering, this is the most recently added token, for LIFO it is the least recently added token. A null token removes all the tokens already there. The number of tokens replaced is equal to the weight of the incoming edge, which defaults to 1. For object nodes that are the target of continuous flows,  overwrite  and  nobuffer  have the same effect. The stereotype does not override UML token offering semantics, just indicates what happens to the token when it is accepted. When the stereotype is not applied, the semantics is as in UML, specifically, tokens arriving at object nodes do not replace ones that are already there.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getOverwrite()
{
return getStereotype(Overwrite.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isOverwrite(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ObjectNode){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getOverwrite());
}
return false;
}

public static class ParticipantProperty extends AbstractStereotypeWrapper {


//stereotype ParticipantProperty and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ParticipantProperty";

/**
* A member end of the association block owning the property on which the stereotype is applied.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String END = "end";
@SuppressWarnings("UnusedDeclaration")
public static void setEnd(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getParticipantProperty(), END, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearEnd(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getParticipantProperty(), END, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getEnd(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getParticipantProperty(), END));
}

}


/**
* The Block stereotype extends Class, so it can be applied to any specialization of Class, including Association Classes. These are informally called  association blocks.  An association block can own properties and connectors, like any other block. Each instance of an association block can link together instances of the end classifiers of the association. To refer to linked objects and values of an instance of an association block, it is necessary for the modeler to specify which (participant) properties of the association block identify the instances being linked at which end of the association. The value of a participant property on an instance (link) of the association block is the value or object at the end of the link corresponding to this end of the association.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getParticipantProperty()
{
return getStereotype(ParticipantProperty.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isParticipantProperty(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getParticipantProperty());
}
return false;
}

public static class Probability extends AbstractStereotypeWrapper {


//stereotype Probability and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Probability";

/**
* When the  probability  stereotype is applied to edges coming out of decision nodes and object nodes, it provides an
expression for the probability that the edge will be traversed. These must be between zero and one inclusive (percentage is supported too), and add up
to one for edges with same source at the time the probabilities are used.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String PROBABILITY = "probability";
@SuppressWarnings("UnusedDeclaration")
public static void setProbability(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getProbability(), PROBABILITY, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearProbability(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getProbability(), PROBABILITY, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getProbability(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getProbability(), PROBABILITY));
}

}


/**
* When the  probability  stereotype is applied to edges coming out of decision nodes and object nodes, it provides an expression for the probability that the edge will be traversed. These must be between zero and one inclusive, and add up to one for edges with same source at the time the probabilities are used.
When the  probability  stereotype is applied to output parameter sets, it gives the probability the parameter set will be given values at runtime. These must be between zero and one inclusive, and add up to one for output parameter sets of the same behavior at the time the probabilities are used.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getProbability()
{
return getStereotype(Probability.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isProbability(@CheckForNull Element element)
{
if((element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ActivityEdge
|| element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdcompleteactivities.ParameterSet)){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getProbability());
}
return false;
}

public static class Problem extends AbstractStereotypeWrapper {


//stereotype Problem and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Problem";
}


/**
* A Problem documents a deficiency, limitation, or failure of one or more model elements to satisfy a requirement or need, or other undesired outcome. It may be used to capture problems identified during analysis, design, verification, or manufacture and associate the problem with the relevant model elements. Problem is a stereotype of comment and may be attached to any other model element in the same manner as a comment.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getProblem()
{
return getStereotype(Problem.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isProblem(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Comment){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getProblem());
}
return false;
}

public static class PropertySpecificType extends AbstractStereotypeWrapper {


//stereotype PropertySpecificType and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "PropertySpecificType";
}


/**
* The PropertySpecificType stereotype should automatically be applied to the classifier which types a property with a propertyspecific type. This classifier can contain definitions of new or redefined features which extend the original classifier referenced by the property-specific type.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getPropertySpecificType()
{
return getStereotype(PropertySpecificType.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isPropertySpecificType(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getPropertySpecificType());
}
return false;
}

public static class ProxyPort extends AbstractStereotypeWrapper {


//stereotype ProxyPort and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ProxyPort";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getProxyPort()
{
return getStereotype(ProxyPort.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isProxyPort(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getProxyPort());
}
return false;
}

public static class Rate extends AbstractStereotypeWrapper {


//stereotype Rate and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Rate";

/**
* Specifies the expected value of the number of objects and values that traverse the edge per time interval, that is, the expected value rate at which they leave the source node and
arrive at the target node. It does not refer to the rate at which a value changes over time. When the stereotype is applied
to a parameter, the parameter must be streaming, and the stereotype gives the number of objects or values that flow in or
out of the parameter per time interval while the behavior or operation is executing.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String RATE = "rate";
@SuppressWarnings("UnusedDeclaration")
public static void setRate(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getRate(), RATE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearRate(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getRate(), RATE, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getRate(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getRate(), RATE));
}

}


/**
* When the  rate  stereotype is applied to an activity edge, it specifies the expected value of the number of objects and values that traverse the edge per time interval, that is, the expected value rate at which they leave the source node and arrive at the target node. It does not refer to the rate at which a value changes over time. When the stereotype is applied to a parameter, the parameter must be streaming, and the stereotype gives the number of objects or values that flow in or out of the parameter per time interval while the behavior or operation is executing. Streaming is a characteristic of UML behavior parameters that supports the input and output of items while a behavior is executing, rather than only when the behavior starts and stops. The flow may be continuous or discrete. The  rate  stereotype has a rate property of type InstanceSpecification. The values of this property must be instances of classifiers stereotyped by  valueType  or  distributionDefinition . In particular, the denominator for units used in the rate property must be time units.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getRate()
{
return getStereotype(Rate.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isRate(@CheckForNull Element element)
{
if((element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ActivityEdge
|| element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ObjectNode
|| element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Parameter)){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getRate());
}
return false;
}

public static class Rationale extends AbstractStereotypeWrapper {


//stereotype Rationale and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Rationale";
}


/**
* A Rationale documents the justification for decisions and the requirements, design, and other decisions. A Rationale can be attached to any model element including relationships. It allows the user, for example, to specify a rationale that may reference more detailed documentation such as a trade study or analysis report. Rationale is a stereotype of comment and may be attached to any other model element in the same manner as a comment.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getRationale()
{
return getStereotype(Rationale.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isRationale(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Comment){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getRationale());
}
return false;
}

public static class Refine extends AbstractStereotypeWrapper {


//stereotype Refine and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Refine";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getRefine()
{
return getStereotype(Refine.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isRefine(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getRefine());
}
return false;
}

public static class Requirement extends AbstractStereotypeWrapper {


//stereotype Requirement and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Requirement";
}


/**
* A requirement specifies a capability or condition that must (or should) be satisfied. A requirement may specify a function that a system must perform or a performance condition that a system must satisfy. Requirements are used to establish a contract between the customer (or other stakeholder) and those responsible for designing and implementing the system.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getRequirement()
{
return getStereotype(Requirement.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isRequirement(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getRequirement());
}
return false;
}

public static class RequirementRelated extends AbstractStereotypeWrapper {


//stereotype RequirementRelated and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "RequirementRelated";

/**
* Derived from all requirements that are the supplier of a  refine  relationship for which this element is a client.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String REFINES = "Refines";

/**
* Derived from all requirements that are the supplier of a  satisfy  relationship for which this element is a client.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String SATISFIES = "Satisfies";

/**
* Derived from all requirements that are the supplier of a  trace  relationship for which this element is a client.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String TRACEDFROM = "TracedFrom";

/**
* Derived from all requirements that are the supplier of a  verify  relationship for which this element is a client.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String VERIFIES = "Verifies";
@SuppressWarnings("UnusedDeclaration")
public static void setRefines(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), REFINES, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearRefines(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getRequirementRelated(), REFINES, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addRefines(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), REFINES, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeRefines(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getRefines(element));
values.remove(value);
setRefines(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getRefines(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), REFINES));
}

@SuppressWarnings("UnusedDeclaration")
public static void setSatisfies(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), SATISFIES, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearSatisfies(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getRequirementRelated(), SATISFIES, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addSatisfies(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), SATISFIES, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeSatisfies(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getSatisfies(element));
values.remove(value);
setSatisfies(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getSatisfies(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), SATISFIES));
}

@SuppressWarnings("UnusedDeclaration")
public static void setTracedFrom(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), TRACEDFROM, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearTracedFrom(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getRequirementRelated(), TRACEDFROM, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addTracedFrom(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), TRACEDFROM, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeTracedFrom(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getTracedFrom(element));
values.remove(value);
setTracedFrom(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getTracedFrom(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), TRACEDFROM));
}

@SuppressWarnings("UnusedDeclaration")
public static void setVerifies(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), VERIFIES, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearVerifies(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getRequirementRelated(), VERIFIES, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addVerifies(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), VERIFIES, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeVerifies(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getVerifies(element));
values.remove(value);
setVerifies(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getVerifies(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getRequirementRelated(), VERIFIES));
}

}


/**
* This stereotype is used to add properties to those elements that are related to requirements via the various dependencies.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getRequirementRelated()
{
return getStereotype(RequirementRelated.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isRequirementRelated(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getRequirementRelated());
}
return false;
}

public static class Satisfy extends AbstractStereotypeWrapper {


//stereotype Satisfy and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Satisfy";
}


/**
* A Satisfy relationship is a dependency between a requirement and a model element that fulfills the requirement. As with other dependencies, the arrow direction points from the satisfying (client) model element to the (supplier) requirement that is satisfied.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSatisfy()
{
return getStereotype(Satisfy.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSatisfy(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getSatisfy());
}
return false;
}

public static class Sensor extends AbstractStereotypeWrapper {


//stereotype Sensor and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Sensor";
}


/**
* A Sensor is a special external system that forwards information from the environment to the system under development. For example a Temperature sensor.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSensor()
{
return getStereotype(Sensor.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSensor(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.mdusecases.Actor){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getSensor());
}
return false;
}

public static class Stakeholder extends AbstractStereotypeWrapper {


//stereotype Stakeholder and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Stakeholder";
@SuppressWarnings("UnusedDeclaration")
public static final String CONCERN = "concern";
@SuppressWarnings("UnusedDeclaration")
public static final String CONCERNLIST = "concernList";
@SuppressWarnings("UnusedDeclaration")
public static void setConcern(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getStakeholder(), CONCERN, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearConcern(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getStakeholder(), CONCERN, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addConcern(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getStakeholder(), CONCERN, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeConcern(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getConcern(element));
values.remove(value);
setConcern(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getConcern(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getStakeholder(), CONCERN));
}

@SuppressWarnings("UnusedDeclaration")
public static void setConcernList(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getStakeholder(), CONCERNLIST, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearConcernList(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getStakeholder(), CONCERNLIST, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getConcernList(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getStakeholder(), CONCERNLIST));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getStakeholder()
{
return getStereotype(Stakeholder.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isStakeholder(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getStakeholder());
}
return false;
}

public static class Subsystem extends AbstractStereotypeWrapper {


//stereotype Subsystem and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Subsystem";
}


/**
* A Subsystem is a - typically large - encapsulated block within a larger system.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSubsystem()
{
return getStereotype(Subsystem.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSubsystem(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getSubsystem());
}
return false;
}

public static class SwimLaneDiagram extends AbstractStereotypeWrapper {


//stereotype SwimLaneDiagram and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "SwimLaneDiagram";
}


/**
* Activity diagram usage with swim lanes.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSwimLaneDiagram()
{
return getStereotype(SwimLaneDiagram.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSwimLaneDiagram(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Diagram){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getSwimLaneDiagram());
}
return false;
}

public static class System extends AbstractStereotypeWrapper {


//stereotype System and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "System";
}


/**
* A System is an artificial artifact consisting of blocks that pursue a common goal that cannot be achieved by the system's individual elements. A block can be software, hardware, a person, or an arbitrary unit.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSystem()
{
return getStereotype(System.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSystem(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getSystem());
}
return false;
}

public static class Systemcontext extends AbstractStereotypeWrapper {


//stereotype System context and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "System context";
}


/**
* A System context element is a virtual container that includes the entire system and its actors.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSystemcontext()
{
return getStereotype(Systemcontext.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSystemcontext(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getSystemcontext());
}
return false;
}

public static class Systemprocess extends AbstractStereotypeWrapper {


//stereotype System process and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "System process";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getSystemprocess()
{
return getStereotype(Systemprocess.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isSystemprocess(@CheckForNull Element element)
{
if((element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity
|| element instanceof com.nomagic.uml2.ext.magicdraw.mdusecases.UseCase)){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getSystemprocess());
}
return false;
}

public static class TestCase extends AbstractStereotypeWrapper {


//stereotype TestCase and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "TestCase";
}


/**
* A test case is a method for verifying a requirement is satisfied.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getTestCase()
{
return getStereotype(TestCase.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isTestCase(@CheckForNull Element element)
{
if((element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Operation
|| element instanceof com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior)){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getTestCase());
}
return false;
}

public static class Trace extends AbstractStereotypeWrapper {


//stereotype Trace and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Trace";
}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getTrace()
{
return getStereotype(Trace.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isTrace(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getTrace());
}
return false;
}

public static class TriggerOnNestedPort extends AbstractStereotypeWrapper {


//stereotype TriggerOnNestedPort and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "TriggerOnNestedPort";
@SuppressWarnings("UnusedDeclaration")
public static final String ONNESTEDPORT = "onNestedPort";
@SuppressWarnings("UnusedDeclaration")
public static void setOnNestedPort(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getTriggerOnNestedPort(), ONNESTEDPORT, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearOnNestedPort(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getTriggerOnNestedPort(), ONNESTEDPORT, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addOnNestedPort(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getTriggerOnNestedPort(), ONNESTEDPORT, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeOnNestedPort(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getOnNestedPort(element));
values.remove(value);
setOnNestedPort(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getOnNestedPort(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getTriggerOnNestedPort(), ONNESTEDPORT));
}

}

@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getTriggerOnNestedPort()
{
return getStereotype(TriggerOnNestedPort.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isTriggerOnNestedPort(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Trigger){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getTriggerOnNestedPort());
}
return false;
}

public static class Uniform extends AbstractStereotypeWrapper {


//stereotype Uniform and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Uniform";
}


/**
* Uniform distribution - constant probability between min and max
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getUniform()
{
return getStereotype(Uniform.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isUniform(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getUniform());
}
return false;
}

public static class Usersystem extends AbstractStereotypeWrapper {


//stereotype User system and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "User system";
}


/**
* An User system is a special external system that serves as medium between a user and the system without having
own interests in the communication. For example Input device or Display.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getUsersystem()
{
return getStereotype(Usersystem.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isUsersystem(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.mdusecases.Actor){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getUsersystem());
}
return false;
}

public static class ValueType extends AbstractStereotypeWrapper {


//stereotype ValueType and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "ValueType";

/**
* A kind of quantity that may be stated by means of defined units, as identified by an instance of the Dimension stereotype. A value type may optionally specify a dimension without any unit. Such a value has no concrete representation, but may be used to express a value in an abstract form independent of any specific units.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String QUANTITYKIND = "quantityKind";

/**
* A quantity in terms of which the magnitudes of other quantities that have the same dimension can be stated, as identified by an instance of the Unit stereotype.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String UNIT = "unit";
@SuppressWarnings("UnusedDeclaration")
public static void setQuantityKind(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getValueType(), QUANTITYKIND, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearQuantityKind(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getValueType(), QUANTITYKIND, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getQuantityKind(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getValueType(), QUANTITYKIND));
}

@SuppressWarnings("UnusedDeclaration")
public static void setUnit(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getValueType(), UNIT, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearUnit(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getValueType(), UNIT, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getUnit(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getValueType(), UNIT));
}

}


/**
* A ValueType defines types of values that may be used to express information about a system, but cannot be identified as the target of any reference. Since a value cannot be identified except by means of the value itself, each such value within a model is independent of any other, unless other forms of constraints are imposed. Value types may be used to type properties, operation parameters, or potentially other elements within SysML. SysML defines ValueType as a stereotype of UML DataType to establish a more neutral term for system values that may never be given a concrete data representation.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getValueType()
{
return getStereotype(ValueType.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isValueType(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.DataType){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getValueType());
}
return false;
}

public static class Verify extends AbstractStereotypeWrapper {


//stereotype Verify and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Verify";
}


/**
* A Verify relationship is a dependency between a requirement and a test case or other model element that can determine whether a system fulfills the requirement. As with other dependencies, the arrow direction points from the (client) element to the (supplier) requirement.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getVerify()
{
return getStereotype(Verify.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isVerify(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getVerify());
}
return false;
}

public static class View extends AbstractStereotypeWrapper {


//stereotype View and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "View";
@SuppressWarnings("UnusedDeclaration")
public static final String STAKEHOLDER = "stakeholder";

/**
* The viewpoint for this View, derived from the supplier of the  conform  dependency whose client is this View.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String VIEWPOINT = "viewPoint";
@SuppressWarnings("UnusedDeclaration")
public static void setStakeholder(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getView(), STAKEHOLDER, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearStakeholder(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getView(), STAKEHOLDER, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addStakeholder(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getView(), STAKEHOLDER, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeStakeholder(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getStakeholder(element));
values.remove(value);
setStakeholder(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getStakeholder(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getView(), STAKEHOLDER));
}

@SuppressWarnings("UnusedDeclaration")
public static void setViewPoint(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getView(), VIEWPOINT, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearViewPoint(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getView(), VIEWPOINT, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static Element getViewPoint(Element element){
return (Element)(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getView(), VIEWPOINT));
}

}


/**
* A View is a representation of a whole system or subsystem from the perspective of a single viewpoint. Views are allowed to import other elements including other packages and other views that conform to the viewpoint.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getView()
{
return getStereotype(View.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isView(@CheckForNull Element element)
{
if((element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
|| element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package)){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getView());
}
return false;
}

public static class Viewpoint extends AbstractStereotypeWrapper {


//stereotype Viewpoint and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "Viewpoint";
@SuppressWarnings("UnusedDeclaration")
public static final String CONCERN = "concern";

/**
* The interest of the stakeholders.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String CONCERNLIST = "concernList";

/**
* The languages used to construct the viewpoint.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String LANGUAGE = "language";

/**
* The methods used to construct the views for this viewpoint.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String METHOD = "method";
@SuppressWarnings("UnusedDeclaration")
public static final String PRESENTATION = "presentation";

/**
* The purpose addresses the stakeholder concerns.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String PURPOSE = "purpose";

/**
* Set of stakeholders.
*/
@SuppressWarnings("UnusedDeclaration")
public static final String STAKEHOLDER = "stakeholder";
@SuppressWarnings("UnusedDeclaration")
public static void setConcern(Element element, java.util.List<String> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), CONCERN, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearConcern(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getViewpoint(), CONCERN, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addConcern(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), CONCERN, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeConcern(Element element, String value){
java.util.List<String> values = new java.util.ArrayList<>(getConcern(element));
values.remove(value);
setConcern(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<String> getConcern(Element element){
return (java.util.List<String>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getViewpoint(), CONCERN));
}

@SuppressWarnings("UnusedDeclaration")
public static void setConcernList(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), CONCERNLIST, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearConcernList(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getViewpoint(), CONCERNLIST, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addConcernList(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), CONCERNLIST, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeConcernList(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getConcernList(element));
values.remove(value);
setConcernList(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getConcernList(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getViewpoint(), CONCERNLIST));
}

@SuppressWarnings("UnusedDeclaration")
public static void setLanguage(Element element, java.util.List<String> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), LANGUAGE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearLanguage(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getViewpoint(), LANGUAGE, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addLanguage(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), LANGUAGE, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeLanguage(Element element, String value){
java.util.List<String> values = new java.util.ArrayList<>(getLanguage(element));
values.remove(value);
setLanguage(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<String> getLanguage(Element element){
return (java.util.List<String>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getViewpoint(), LANGUAGE));
}

@SuppressWarnings("UnusedDeclaration")
public static void setMethod(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), METHOD, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearMethod(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getViewpoint(), METHOD, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addMethod(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), METHOD, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeMethod(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getMethod(element));
values.remove(value);
setMethod(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getMethod(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getViewpoint(), METHOD));
}

@SuppressWarnings("UnusedDeclaration")
public static void setPresentation(Element element, java.util.List<String> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), PRESENTATION, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearPresentation(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getViewpoint(), PRESENTATION, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addPresentation(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), PRESENTATION, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removePresentation(Element element, String value){
java.util.List<String> values = new java.util.ArrayList<>(getPresentation(element));
values.remove(value);
setPresentation(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<String> getPresentation(Element element){
return (java.util.List<String>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getViewpoint(), PRESENTATION));
}

@SuppressWarnings("UnusedDeclaration")
public static void setPurpose(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), PURPOSE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearPurpose(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getViewpoint(), PURPOSE, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getPurpose(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getViewpoint(), PURPOSE));
}

@SuppressWarnings("UnusedDeclaration")
public static void setStakeholder(Element element, java.util.List<Element> value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), STAKEHOLDER, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearStakeholder(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getViewpoint(), STAKEHOLDER, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void addStakeholder(Element element, Element value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getViewpoint(), STAKEHOLDER, value, true);
}

@SuppressWarnings("UnusedDeclaration")
public static void removeStakeholder(Element element, Element value){
java.util.List<Element> values = new java.util.ArrayList<>(getStakeholder(element));
values.remove(value);
setStakeholder(element, values);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@Nonnull
public static java.util.List<Element> getStakeholder(Element element){
return (java.util.List<Element>)(StereotypesHelper.getStereotypePropertyValue(element, getInstance(element).getViewpoint(), STAKEHOLDER));
}

}


/**
* A Viewpoint is a specification of the conventions and rules for constructing and using a view for the purpose of addressing a set of stakeholder concerns. The languages and methods for specifying a view may reference languages and methods in another viewpoint. They specify the elements expected to be represented in the view, and may be formally or informally defined. For example, the security viewpoint may require the security requirements, security functional and physical architecture, and security test cases.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getViewpoint()
{
return getStereotype(Viewpoint.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isViewpoint(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getViewpoint());
}
return false;
}

public static class BusinessRequirement extends AbstractStereotypeWrapper {


//stereotype businessRequirement and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "businessRequirement";
}


/**
* High-level business requirement.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getBusinessRequirement()
{
return getStereotype(BusinessRequirement.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isBusinessRequirement(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getBusinessRequirement());
}
return false;
}

public static class DesignConstraint extends AbstractStereotypeWrapper {


//stereotype designConstraint and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "designConstraint";
}


/**
* Requirement that specifies a constraint on the implementation of the system or system part, such as the system must use a commercial off the shelf component.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getDesignConstraint()
{
return getStereotype(DesignConstraint.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isDesignConstraint(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getDesignConstraint());
}
return false;
}

public static class DiagramUsage extends AbstractStereotypeWrapper {


//stereotype diagramUsage and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "diagramUsage";
}


/**
* SysML also introduces the concept of a diagram usage. This represents a unique usage of a particular diagram type, such as a context diagram as a usage of an block definition diagram, internal block diagram, or use case diagram. The diagram usage can be identified in the header above the diagramKind as  diagramUsage .
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getDiagramUsage()
{
return getStereotype(DiagramUsage.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isDiagramUsage(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Diagram){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getDiagramUsage());
}
return false;
}

public static class Effbd extends AbstractStereotypeWrapper {


//stereotype effbd and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "effbd";
}


/**
* Enhanced Functional Flow Block Diagrams (EFFBD) are a widely-used systems engineering diagram, also called a behavior diagram. Most of its functionality is a constrained use of UML activities. EFFBD specifies that the activity conforms to the constraints necessary for EFFBD.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getEffbd()
{
return getStereotype(Effbd.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isEffbd(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getEffbd());
}
return false;
}

public static class ExtendedRequirement extends AbstractStereotypeWrapper {


//stereotype extendedRequirement and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "extendedRequirement";
@SuppressWarnings("UnusedDeclaration")
public static final String RISK = "risk";
@SuppressWarnings("UnusedDeclaration")
public static final String SOURCE = "source";
@SuppressWarnings("UnusedDeclaration")
public static final String VERIFYMETHOD = "verifyMethod";
@SuppressWarnings("UnusedDeclaration")
public static void setRisk(Element element, RiskKindEnum value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getExtendedRequirement(), RISK, value != null ? value.getText() : null);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearRisk(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getExtendedRequirement(), RISK, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static RiskKindEnum getRisk(Element element){
return RiskKindEnum.from(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getExtendedRequirement(), RISK));
}

@SuppressWarnings("UnusedDeclaration")
public static void setSource(Element element, String value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getExtendedRequirement(), SOURCE, value);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearSource(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getExtendedRequirement(), SOURCE, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static String getSource(Element element){
return toString(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getExtendedRequirement(), SOURCE));
}

@SuppressWarnings("UnusedDeclaration")
public static void setVerifyMethod(Element element, VerificationMethodKindEnum value){
StereotypesHelper.setStereotypePropertyValue(element, getInstance(element).getExtendedRequirement(), VERIFYMETHOD, value != null ? value.getText() : null);
}

@SuppressWarnings("UnusedDeclaration")
public static void clearVerifyMethod(Element element){
StereotypesHelper.clearStereotypeProperty(element, getInstance(element).getExtendedRequirement(), VERIFYMETHOD, true);
}

@SuppressWarnings("UnusedDeclaration, unchecked")
@CheckForNull
public static VerificationMethodKindEnum getVerifyMethod(Element element){
return VerificationMethodKindEnum.from(StereotypesHelper.getStereotypePropertyFirst(element, getInstance(element).getExtendedRequirement(), VERIFYMETHOD));
}

}


/**
* A mix-in stereotype that contains generally useful attributes for requirements
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getExtendedRequirement()
{
return getStereotype(ExtendedRequirement.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isExtendedRequirement(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getExtendedRequirement());
}
return false;
}

public static class FunctionalRequirement extends AbstractStereotypeWrapper {


//stereotype functionalRequirement and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "functionalRequirement";
}


/**
* Requirement that specifies an operation or behavior that a system, or part of a system, must perform.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getFunctionalRequirement()
{
return getStereotype(FunctionalRequirement.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isFunctionalRequirement(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getFunctionalRequirement());
}
return false;
}

public static class InterfaceRequirement extends AbstractStereotypeWrapper {


//stereotype interfaceRequirement and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "interfaceRequirement";
}


/**
* Requirement that specifies the ports for connecting systems and system parts and the optionally may include the item flows across the connector and/or Interface constraints.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getInterfaceRequirement()
{
return getStereotype(InterfaceRequirement.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isInterfaceRequirement(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getInterfaceRequirement());
}
return false;
}

public static class Moe extends AbstractStereotypeWrapper {


//stereotype moe and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "moe";
}


/**
* A measure of effectiveness (moe) represents a parameter whose value is critical for achieving the desired mission cost effectiveness.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getMoe()
{
return getStereotype(Moe.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isMoe(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getMoe());
}
return false;
}

public static class NonStreaming extends AbstractStereotypeWrapper {


//stereotype nonStreaming and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "nonStreaming";
}


/**
* Used for activities that accept inputs only when they start, and provide outputs only when they finish.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getNonStreaming()
{
return getStereotype(NonStreaming.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isNonStreaming(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getNonStreaming());
}
return false;
}

public static class ObjectiveFunction extends AbstractStereotypeWrapper {


//stereotype objectiveFunction and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "objectiveFunction";
}


/**
* An objective function (aka optimization or cost function) is used to determine the overall value of an alternative in terms of weighted criteria and/or moe s.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getObjectiveFunction()
{
return getStereotype(ObjectiveFunction.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isObjectiveFunction(@CheckForNull Element element)
{
if((element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
|| element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property)){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getObjectiveFunction());
}
return false;
}

public static class PerformanceRequirement extends AbstractStereotypeWrapper {


//stereotype performanceRequirement and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "performanceRequirement";
}


/**
* Requirement that quantitatively measures the extent to which a system, or a system part, satisfies a required capability or condition.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getPerformanceRequirement()
{
return getStereotype(PerformanceRequirement.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isPerformanceRequirement(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getPerformanceRequirement());
}
return false;
}

public static class PhysicalRequirement extends AbstractStereotypeWrapper {


//stereotype physicalRequirement and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "physicalRequirement";
}


/**
* Requirement that specifies physical characteristics and/or physical constraints of the system, or a system part.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getPhysicalRequirement()
{
return getStereotype(PhysicalRequirement.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isPhysicalRequirement(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getPhysicalRequirement());
}
return false;
}

public static class Streaming extends AbstractStereotypeWrapper {


//stereotype streaming and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "streaming";
}


/**
* Used for activities that can accept inputs or provide outputs after they start and before they finish.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getStreaming()
{
return getStereotype(Streaming.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isStreaming(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getStreaming());
}
return false;
}

public static class UsabilityRequirement extends AbstractStereotypeWrapper {


//stereotype usabilityRequirement and its tags
@SuppressWarnings("UnusedDeclaration")
public static final String STEREOTYPE_NAME = "usabilityRequirement";
}


/**
* Requirement about usability.
*@return stereotype
*/
@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public Stereotype getUsabilityRequirement()
{
return getStereotype(UsabilityRequirement.STEREOTYPE_NAME);
}

@SuppressWarnings("UnusedDeclaration")
public static boolean isUsabilityRequirement(@CheckForNull Element element)
{
if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class){
SysML instance=getInstance(element);
return instance.isTypeOf(element, instance.getUsabilityRequirement());
}
return false;
}



@Override
protected Collection<Stereotype> generatedGetAllStereotypes()
{
if (getProfile() != null)
{
final Collection<Stereotype> stereotypes = new HashSet<>();

stereotypes.add(getAbstractRequirement());
stereotypes.add(getAcceptChangeStructuralFeatureEventAction());
stereotypes.add(getActuator());
stereotypes.add(getAdjunctProperty());
stereotypes.add(getAllocate());
stereotypes.add(getAllocateActivityPartition());
stereotypes.add(getAllocated());
stereotypes.add(getBasicInterval());
stereotypes.add(getBindingConnector());
stereotypes.add(getBlock());
stereotypes.add(getBlockHierarchy());
stereotypes.add(getBoundReference());
stereotypes.add(getBoundarysystem());
stereotypes.add(getChangeStructuralFeatureEvent());
stereotypes.add(getClassifierBehaviorProperty());
stereotypes.add(getConform());
stereotypes.add(getConnectorProperty());
stereotypes.add(getConstraintBlock());
stereotypes.add(getContextDiagram());
stereotypes.add(getContinuous());
stereotypes.add(getControlOperator());
stereotypes.add(getCopy());
stereotypes.add(getDeriveReqt());
stereotypes.add(getDiagramDescription());
stereotypes.add(getDirectedFeature());
stereotypes.add(getDirectedRelationshipPropertyPath());
stereotypes.add(getDiscrete());
stereotypes.add(getDistributedProperty());
stereotypes.add(getDomain());
stereotypes.add(getElementGroup());
stereotypes.add(getElementPropertyPath());
stereotypes.add(getEndPathMultiplicity());
stereotypes.add(getEnvironmentaleffect());
stereotypes.add(getEssential());
stereotypes.add(getExpose());
stereotypes.add(getExternal());
stereotypes.add(getExternalsystem());
stereotypes.add(getFlowPort());
stereotypes.add(getFlowProperty());
stereotypes.add(getFlowSpecification());
stereotypes.add(getFullPort());
stereotypes.add(getInterfaceBlock());
stereotypes.add(getInterval());
stereotypes.add(getInvocationOnNestedPortAction());
stereotypes.add(getItemFlow());
stereotypes.add(getNestedConnectorEnd());
stereotypes.add(getNoBuffer());
stereotypes.add(getNormal());
stereotypes.add(getOptional());
stereotypes.add(getOverwrite());
stereotypes.add(getParticipantProperty());
stereotypes.add(getProbability());
stereotypes.add(getProblem());
stereotypes.add(getPropertySpecificType());
stereotypes.add(getProxyPort());
stereotypes.add(getRate());
stereotypes.add(getRationale());
stereotypes.add(getRefine());
stereotypes.add(getRequirement());
stereotypes.add(getRequirementRelated());
stereotypes.add(getSatisfy());
stereotypes.add(getSensor());
stereotypes.add(getStakeholder());
stereotypes.add(getSubsystem());
stereotypes.add(getSwimLaneDiagram());
stereotypes.add(getSystem());
stereotypes.add(getSystemcontext());
stereotypes.add(getSystemprocess());
stereotypes.add(getTestCase());
stereotypes.add(getTrace());
stereotypes.add(getTriggerOnNestedPort());
stereotypes.add(getUniform());
stereotypes.add(getUsersystem());
stereotypes.add(getValueType());
stereotypes.add(getVerify());
stereotypes.add(getView());
stereotypes.add(getViewpoint());
stereotypes.add(getBusinessRequirement());
stereotypes.add(getDesignConstraint());
stereotypes.add(getDiagramUsage());
stereotypes.add(getEffbd());
stereotypes.add(getExtendedRequirement());
stereotypes.add(getFunctionalRequirement());
stereotypes.add(getInterfaceRequirement());
stereotypes.add(getMoe());
stereotypes.add(getNonStreaming());
stereotypes.add(getObjectiveFunction());
stereotypes.add(getPerformanceRequirement());
stereotypes.add(getPhysicalRequirement());
stereotypes.add(getStreaming());
stereotypes.add(getUsabilityRequirement());

return stereotypes;
}

return super.generatedGetAllStereotypes();
}

}
//MD5sum:18BECA00F34317845B9F734AA9F96FC0