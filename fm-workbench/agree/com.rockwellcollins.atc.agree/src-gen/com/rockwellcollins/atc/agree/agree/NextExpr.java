/**
 */
package com.rockwellcollins.atc.agree.agree;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Next Expr</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rockwellcollins.atc.agree.agree.NextExpr#getExpr <em>Expr
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rockwellcollins.atc.agree.agree.AgreePackage#getNextExpr()
 * @model
 * @generated
 */
public interface NextExpr extends Expr {
    /**
     * Returns the value of the '<em><b>Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Expr</em>' containment reference.
     * @see #setExpr(Expr)
     * @see com.rockwellcollins.atc.agree.agree.AgreePackage#getNextExpr_Expr()
     * @model containment="true"
     * @generated
     */
    Expr getExpr();

    /**
     * Sets the value of the '
     * {@link com.rockwellcollins.atc.agree.agree.NextExpr#getExpr
     * <em>Expr</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Expr</em>' containment reference.
     * @see #getExpr()
     * @generated
     */
    void setExpr(Expr value);

} // NextExpr
