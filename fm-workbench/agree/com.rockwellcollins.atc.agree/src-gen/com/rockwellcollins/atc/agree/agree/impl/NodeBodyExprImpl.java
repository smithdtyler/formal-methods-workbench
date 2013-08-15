/**
 */
package com.rockwellcollins.atc.agree.agree.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.impl.ElementImpl;

import com.rockwellcollins.atc.agree.agree.AgreePackage;
import com.rockwellcollins.atc.agree.agree.Arg;
import com.rockwellcollins.atc.agree.agree.NodeBodyExpr;
import com.rockwellcollins.atc.agree.agree.NodeEq;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Node Body Expr</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rockwellcollins.atc.agree.agree.impl.NodeBodyExprImpl#getLocs
 * <em>Locs</em>}</li>
 * <li>{@link com.rockwellcollins.atc.agree.agree.impl.NodeBodyExprImpl#getEqs
 * <em>Eqs</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NodeBodyExprImpl extends ElementImpl implements NodeBodyExpr {
    /**
     * The cached value of the '{@link #getLocs() <em>Locs</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLocs()
     * @generated
     * @ordered
     */
    protected EList<Arg> locs;

    /**
     * The cached value of the '{@link #getEqs() <em>Eqs</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEqs()
     * @generated
     * @ordered
     */
    protected EList<NodeEq> eqs;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NodeBodyExprImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AgreePackage.Literals.NODE_BODY_EXPR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Arg> getLocs() {
        if (locs == null) {
            locs = new EObjectContainmentEList<Arg>(Arg.class, this,
                    AgreePackage.NODE_BODY_EXPR__LOCS);
        }
        return locs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<NodeEq> getEqs() {
        if (eqs == null) {
            eqs = new EObjectContainmentEList<NodeEq>(NodeEq.class, this,
                    AgreePackage.NODE_BODY_EXPR__EQS);
        }
        return eqs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
            NotificationChain msgs) {
        switch (featureID) {
        case AgreePackage.NODE_BODY_EXPR__LOCS:
            return ((InternalEList<?>) getLocs()).basicRemove(otherEnd, msgs);
        case AgreePackage.NODE_BODY_EXPR__EQS:
            return ((InternalEList<?>) getEqs()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case AgreePackage.NODE_BODY_EXPR__LOCS:
            return getLocs();
        case AgreePackage.NODE_BODY_EXPR__EQS:
            return getEqs();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case AgreePackage.NODE_BODY_EXPR__LOCS:
            getLocs().clear();
            getLocs().addAll((Collection<? extends Arg>) newValue);
            return;
        case AgreePackage.NODE_BODY_EXPR__EQS:
            getEqs().clear();
            getEqs().addAll((Collection<? extends NodeEq>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case AgreePackage.NODE_BODY_EXPR__LOCS:
            getLocs().clear();
            return;
        case AgreePackage.NODE_BODY_EXPR__EQS:
            getEqs().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case AgreePackage.NODE_BODY_EXPR__LOCS:
            return locs != null && !locs.isEmpty();
        case AgreePackage.NODE_BODY_EXPR__EQS:
            return eqs != null && !eqs.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // NodeBodyExprImpl
