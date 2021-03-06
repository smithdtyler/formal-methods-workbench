/**
 * generated by Xtext 2.11.0
 */
package edu.uah.rsesc.aadlsimulator.xtext.inputConstraint;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.IntervalExpression#isLeftClosed <em>Left Closed</em>}</li>
 *   <li>{@link edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.IntervalExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.IntervalExpression#getRight <em>Right</em>}</li>
 *   <li>{@link edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.IntervalExpression#isRightClosed <em>Right Closed</em>}</li>
 * </ul>
 *
 * @see edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.InputConstraintPackage#getIntervalExpression()
 * @model
 * @generated
 */
public interface IntervalExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Left Closed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Closed</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Closed</em>' attribute.
   * @see #setLeftClosed(boolean)
   * @see edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.InputConstraintPackage#getIntervalExpression_LeftClosed()
   * @model
   * @generated
   */
  boolean isLeftClosed();

  /**
   * Sets the value of the '{@link edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.IntervalExpression#isLeftClosed <em>Left Closed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Closed</em>' attribute.
   * @see #isLeftClosed()
   * @generated
   */
  void setLeftClosed(boolean value);

  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(ScalarExpression)
   * @see edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.InputConstraintPackage#getIntervalExpression_Left()
   * @model containment="true"
   * @generated
   */
  ScalarExpression getLeft();

  /**
   * Sets the value of the '{@link edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.IntervalExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(ScalarExpression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(ScalarExpression)
   * @see edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.InputConstraintPackage#getIntervalExpression_Right()
   * @model containment="true"
   * @generated
   */
  ScalarExpression getRight();

  /**
   * Sets the value of the '{@link edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.IntervalExpression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(ScalarExpression value);

  /**
   * Returns the value of the '<em><b>Right Closed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Closed</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Closed</em>' attribute.
   * @see #setRightClosed(boolean)
   * @see edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.InputConstraintPackage#getIntervalExpression_RightClosed()
   * @model
   * @generated
   */
  boolean isRightClosed();

  /**
   * Sets the value of the '{@link edu.uah.rsesc.aadlsimulator.xtext.inputConstraint.IntervalExpression#isRightClosed <em>Right Closed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Closed</em>' attribute.
   * @see #isRightClosed()
   * @generated
   */
  void setRightClosed(boolean value);

} // IntervalExpression
