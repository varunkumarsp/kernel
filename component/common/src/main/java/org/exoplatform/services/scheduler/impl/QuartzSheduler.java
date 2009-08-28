/*
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.services.scheduler.impl;

import org.picocontainer.Startable;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by The eXo Platform SAS Author : Tuan Nguyen
 * tuan08@users.sourceforge.net Dec 13, 2005
 * 
 * @version $Id: QuartzSheduler.java 34394 2009-07-23 09:23:31Z dkatayev $
 */
public class QuartzSheduler implements Startable
{
   private Scheduler scheduler_;

   public QuartzSheduler() throws Exception
   {
      SchedulerFactory sf = new StdSchedulerFactory();
      scheduler_ = sf.getScheduler();
      scheduler_.start();
   }

   public Scheduler getQuartzSheduler()
   {
      return scheduler_;
   }

   public void start()
   {
   }

   public void stop()
   {
      try
      {
         scheduler_.shutdown();
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }
}