//+======================================================================
// $Source$
//
// Project:   Tango
//
// Description:	source code
//
// $Author: pascal_verdier $
//
// Copyright (C) :      2004,2005,2006,2007,2008
//						European Synchrotron Radiation Facility
//                      BP 220, Grenoble 38043
//                      FRANCE
//
// This file is part of Tango.
//
// Tango is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Tango is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with Tango.  If not, see <http://www.gnu.org/licenses/>.
//
// $Revision: 15087 $
//
// $Log$
// Revision 1.8  2010/05/31 12:21:56  abeilleg
// make the projet compile with maven: remove dependency to javadao
//
// Revision 1.7  2009/12/09 12:17:58  pascal_verdier
// Dependances on Taco.jar have been removed to compile.
//
// Revision 1.6  2009/03/31 07:49:32  pascal_verdier
// Tango-7.
//
// Revision 1.5  2008/10/10 11:38:00  pascal_verdier
// Headers changed for LGPL conformity.
//
//
//-======================================================================

package fr.esrf.Tango.factory;

import fr.esrf.TangoApi.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * 
 * @author BARBA-ROSSA
 * 
 */
public class TangoFactory {
    private static final TangoFactory INSTANCE = new TangoFactory();
    private ITangoFactory tangoFactory;

    private TangoFactory() {
        initTangoFactory();
    }

    public static TangoFactory getSingleton() {
        return INSTANCE;
    }

    /**
     * We instanciate the Component
     *
     * @param className
     * @return Object
     */
    private static Object getObject(final String className) {
        try {
            // we get the class coresponding to the life cycle name
            final Class<?> clazz = Class.forName(className);

            // we get the default constructor (with no parameter)
            final Constructor<?> contructor = clazz.getConstructor(new Class[]{});

            // we create an instance of the class using the constructor
            return contructor.newInstance(new Object[]{});

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Load properties with impl specification and create instances
     *
     */
    private void initTangoFactory() {
        String factoryClassName = "fr.esrf.TangoApi.factory.DefaultTangoFactoryImpl";
        tangoFactory = (ITangoFactory) getObject(factoryClassName);
    }

    public IConnectionDAO getConnectionDAO() {
        return tangoFactory.getConnectionDAO();
    }

    public IDeviceProxyDAO getDeviceProxyDAO() {
        return tangoFactory.getDeviceProxyDAO();
    }

    public IDatabaseDAO getDatabaseDAO() {
        return tangoFactory.getDatabaseDAO();
    }

    public IDeviceAttributeDAO getDeviceAttributeDAO() {
        return tangoFactory.getDeviceAttributeDAO();
    }

    public IDeviceAttribute_3DAO getDeviceAttribute_3DAO() {
        return tangoFactory.getDeviceAttribute_3DAO();
    }

    public IDeviceDataDAO getDeviceDataDAO() {
        return tangoFactory.getDeviceDataDAO();
    }

    public IDeviceDataHistoryDAO getDeviceDataHistoryDAO() {
        return tangoFactory.getDeviceDataHistoryDAO();
    }

    public IApiUtilDAO getApiUtilDAO() {
        return tangoFactory.getApiUtilDAO();
    }

    public IIORDumpDAO getIORDumpDAO() {
        return tangoFactory.getIORDumpDAO();
    }

    public boolean isDefaultFactory() {
        return true;
    }
}
